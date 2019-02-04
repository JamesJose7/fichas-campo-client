package com.jeeps.fichas_campo_client;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
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
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.Ubicacion;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

import java.io.ByteArrayOutputStream;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FichaFormActivity extends AppCompatActivity implements
        ApiFichaCampoAdapter.ApiFichaCampoListener,
        ApiUbicacionAdapter.ApiUbicacionListener {

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

        mApiParserFacade = new ApiParserFacade();
    }

    private void saveFicha() {
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

    private String getAbsUrl(String name, String ubicacionUrl) {
        return "\"" + name + "\": \"" + "/api/" + ubicacionUrl.split("/api/")[1] + "\"";
    }

    @OnClick(R.id.photo_button)
    public void takePhoto(View v) {
        Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePicture, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 0 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            foto.setImageBitmap(imageBitmap);
            Bitmap compressedImage = (Bitmap) extras.get("data");
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            compressedImage.compress(Bitmap.CompressFormat.PNG, 100, stream);
            mByteArray = new String(Base64.getEncoder().encode(stream.toByteArray()));
            //compressedImage.recycle();
        }
    }
}
