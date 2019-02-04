package com.jeeps.fichas_campo_client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jeeps.fichas_campo_client.adapters.ApiAfloramientoAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiEstructuraLinealAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiEstructuraPlanarAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiFichaCampoAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiMuestraAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiPliegueAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiUbicacionAdapter;
import com.jeeps.fichas_campo_client.model.Afloramiento;
import com.jeeps.fichas_campo_client.model.EstructuraLineal;
import com.jeeps.fichas_campo_client.model.EstructuraPlanar;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.Muestra;
import com.jeeps.fichas_campo_client.model.Pliegue;
import com.jeeps.fichas_campo_client.model.Ubicacion;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FichaFormActivity extends AppCompatActivity implements
        ApiFichaCampoAdapter.ApiFichaCampoListener,
        ApiUbicacionAdapter.ApiUbicacionListener,
        ApiPliegueAdapter.ApiPliegueListener,
        ApiMuestraAdapter.ApiMuestraListener,
        ApiEstructuraPlanarAdapter.ApiEstructuraPlanarListener,
        ApiEstructuraLinealAdapter.ApiEstructuraLinealListener,
        ApiAfloramientoAdapter.ApiAfloramientoListener {

    private ApiFichaCampoAdapter mApiFichaCampoAdapter;
    private ApiUbicacionAdapter mApiUbicacionAdapter;
    private ApiPliegueAdapter mApiPliegueAdapter;
    private ApiMuestraAdapter mApiMuestraAdapter;
    private ApiEstructuraPlanarAdapter mApiEstructuraPlanarAdapter;
    private ApiEstructuraLinealAdapter mApiEstructuraLinealAdapter;
    private ApiAfloramientoAdapter mApiAfloramientoAdapter;

    private ApiParserFacade mApiParserFacade;

    // Ficha de campo
    @BindView(R.id.datum_text) EditText datum;
    @BindView(R.id.escala_text) EditText escala;
    @BindView(R.id.proyecto_text) EditText proyecto;
    @BindView(R.id.datos_ubicacion_text) EditText datosUbicacion;
    @BindView(R.id.descrita_por_text) EditText descritaPor;
    @BindView(R.id.nom_unidad_geo_text) EditText nomUnidadGeologica;
    @BindView(R.id.tipo_contacto_text) EditText tipoContacto;
    @BindView(R.id.limite_contacto_text) EditText limiteContacto;
    @BindView(R.id.certeza_contacto_text) EditText certezaContacto;
    @BindView(R.id.origen_roca_text) EditText origenRoca;
    @BindView(R.id.estructura_roca_text) EditText estructuraRoca;

    // Ubicacion
    @BindView(R.id.provincia_text) EditText provincia;
    @BindView(R.id.canton_text) EditText canton;
    @BindView(R.id.sector_text) EditText sector;
    @BindView(R.id.escala_ubicacion_text) EditText escalaUbicacion;
    @BindView(R.id.foto_ubicacion) ImageView foto;

    // Muestra
    @BindView(R.id.naturaleza_text) EditText naturaleza;
    @BindView(R.id.tipo_muestra_text) EditText tipoMuestra;
    @BindView(R.id.consistencia_material_text) EditText consistenciaMaterial;
    @BindView(R.id.codigo_text) EditText codigo;
    @BindView(R.id.sitio_muestra_text) EditText sitioMuestra;
    @BindView(R.id.tipo_analisis_text) EditText tipoAnalisis;
    @BindView(R.id.metodo_analisis_text) EditText metodoAnalisis;
    @BindView(R.id.nom_metodo_analisis_text) EditText nomMetodoAnalisis;
    @BindView(R.id.cantidad_muestra_text) EditText cantidadMuestra;
    @BindView(R.id.observaciones_text) EditText observaciones;

    private String fichaCampoLinks = "";
    private String mByteArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_form);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> {
            saveFicha();
            Snackbar.make(view, "Ficha guardada", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mApiFichaCampoAdapter = new ApiFichaCampoAdapter(this);
        mApiUbicacionAdapter = new ApiUbicacionAdapter(this);
        mApiPliegueAdapter = new ApiPliegueAdapter(this);
        mApiMuestraAdapter = new ApiMuestraAdapter(this);
        mApiEstructuraPlanarAdapter = new ApiEstructuraPlanarAdapter(this);
        mApiEstructuraLinealAdapter = new ApiEstructuraLinealAdapter(this);
        mApiAfloramientoAdapter = new ApiAfloramientoAdapter(this);

        mApiParserFacade = new ApiParserFacade();
    }

    private void saveFicha() {
        // Save muestra
        String codigoTxt = codigo.getText().toString();
        String cantidadMuestraTxt = cantidadMuestra.getText().toString();
        Muestra muestra = new Muestra.MuestraBuilder()
                .createNaturaleza(naturaleza.getText().toString())
                .createTipo(tipoMuestra.getText().toString())
                .createConsistenciaMaterial(consistenciaMaterial.getText().toString())
                .createCodigo(!codigoTxt.isEmpty() ? Long.valueOf(codigoTxt) : 0)
                .createSitio(sitioMuestra.getText().toString())
                .createTipoAnalisis(tipoAnalisis.getText().toString())
                .createMetodoAnalisis(metodoAnalisis.getText().toString())
                .createNomenclaturaMetodoAnalisis(nomMetodoAnalisis.getText().toString())
                .createCantidadMuestra(!cantidadMuestraTxt.isEmpty() ? Long.valueOf(cantidadMuestraTxt) : 0)
                .createObservaciones(observaciones.getText().toString())
                .build();
        mApiMuestraAdapter.saveMuestra(muestra);
    }

    @Override
    public void fichasCampoReady(List<FichaCampo> fichasCampo) {}

    @Override
    public void ubicacionReady(Ubicacion ubicacion) {}

    @Override
    public void ubicacionSaved(String ubicacionUrl) {
        fichaCampoLinks += getAbsUrl("ubicacion", ubicacionUrl) + "\n";

        // Save ficha
        FichaCampo fichaCampo = new FichaCampo.FichaCampoBuilder()
                .createDatum(datum.getText().toString())
                .createEscala(escala.getText().toString())
                .createProyecto(proyecto.getText().toString())
                .createDatosUbicacion(datosUbicacion.getText().toString())
                .createDescritaPor(descritaPor.getText().toString())
                .createNomenclatura(nomUnidadGeologica.getText().toString())
                .createTipoContactoGeo(tipoContacto.getText().toString())
                .createLimiteContactoGeo(limiteContacto.getText().toString())
                .createCertezaContactoGeo(certezaContacto.getText().toString())
                .createOrigenRoca(origenRoca.getText().toString())
                .createEstructuraRoca(estructuraRoca.getText().toString())
                .build();
        fichaCampo.setSubclassesLinks(fichaCampoLinks);

        mApiFichaCampoAdapter.saveFichaCampo(fichaCampo);
    }

    @Override
    public void muestraReady(Muestra muestra) {}

    @Override
    public void muestraSaved(String muestraUrl) {
        fichaCampoLinks += getAbsUrl("muestra", muestraUrl) + ",\n";

        // Save ubicacion
        Ubicacion ubicacion = new Ubicacion.UbicacionBuilder()
                .createFecha(new Date())
                .createProvincia(provincia.getText().toString())
                .createCanton(canton.getText().toString())
                .createSector(sector.getText().toString())
                .createEscala(escala.getText().toString())
                .createFoto(mByteArray)
                .build();
        mApiUbicacionAdapter.saveUbicacion(ubicacion);
    }

    @OnClick(R.id.photo_button)
    public void takePhoto(View v) {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(imageBitmap);
            Bitmap compressedImage = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            compressedImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
            mByteArray = new String(android.util.Base64.encode(stream.toByteArray(), Base64.DEFAULT));
            //compressedImage.recycle();
        }
    }

    private String getAbsUrl(String name, String ubicacionUrl) {
        return "\"" + name + "\": \"" + "/api/" + ubicacionUrl.split("/api/")[1] + "\"";
    }

    @Override
    public void afloramientoReady(Afloramiento afloramiento) {}

    @Override
    public void estructuraLinealReady(EstructuraLineal estructuraLineal) {}

    @Override
    public void estructuraPlanarReady(EstructuraPlanar estructuraPlanar) {}

    @Override
    public void pliegueReady(Pliegue pliegue) {}
}
