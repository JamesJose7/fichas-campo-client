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

    // Afloramiento
    @BindView(R.id.dimension_text) EditText dimension;
    @BindView(R.id.origen_afloramiento_text) EditText origenAfloramiento;
    @BindView(R.id.tipo_roca_text) EditText tipoRoca;
    @BindView(R.id.sitio_afloramiento_text) EditText sitioAfloramiento;

    // Estructura Planar
    @BindView(R.id.buz_intensidad_text) EditText buzamientoIntesidad;
    @BindView(R.id.azimut_text) EditText azimut;
    @BindView(R.id.clivaje_text) EditText clivaje;
    @BindView(R.id.estratificacion_text) EditText estratificacion;
    @BindView(R.id.fotogeologia_text) EditText fotogeologia;
    @BindView(R.id.zona_cizalla_text) EditText zonaCizalla;
    @BindView(R.id.rocas_metaforicas_text) EditText rocasMetaforicas;
    @BindView(R.id.rocas_igneas_text) EditText rocasIgneas;

    // Estructura Linear
    @BindView(R.id.rumbo_estr_lineal_text) EditText rumboEstrLineal;
    @BindView(R.id.clase_estr_lineal_text) EditText claseEstrLineal;
    @BindView(R.id.lineacion_text) EditText lineacion;
    @BindView(R.id.direccion_text) EditText direccion;
    @BindView(R.id.buzamiento_estr_lineal_text) EditText buzamientoEstrLineal;
    @BindView(R.id.asociacion_text) EditText asociacion;
    @BindView(R.id.formacion_text) EditText formacion;
    @BindView(R.id.diaclasa_clase_text) EditText diaclasaClase;

    // Pliegue
    @BindView(R.id.rumbo_pliegue_text) EditText rumboPliegue;
    @BindView(R.id.buzamiento_pliegue_text) EditText buzamientoPliegue;
    @BindView(R.id.tipo_pliegue_text) EditText tipoPliegue;
    @BindView(R.id.altura_text) EditText altura;
    @BindView(R.id.separacion_text) EditText separacion;
    @BindView(R.id.posicion_text) EditText posicion;
    @BindView(R.id.angulo_flancos_text) EditText anguloEntreFlancos;
    @BindView(R.id.perfil_text) EditText perfil;
    @BindView(R.id.sistema_text) EditText sistema;

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

        // Save Afloramiento
        Afloramiento afloramiento = new Afloramiento.AfloramientoBuilder()
                .createDimension(dimension.getText().toString())
                .createOrigen(origenAfloramiento.getText().toString())
                .createTipoRoca(tipoRoca.getText().toString())
                .createSitio(sitioAfloramiento.getText().toString())
                .build();
        mApiAfloramientoAdapter.saveAfloramiento(afloramiento);
    }

    @Override
    public void afloramientoReady(Afloramiento afloramiento) {}

    @Override
    public void afloramientoSaved(String afloramientoUrl) {
        fichaCampoLinks += getAbsUrl("afloramiento", afloramientoUrl) + ",\n";

        // Save Estructura planar
        String azimutTxt = azimut.getText().toString();
        EstructuraPlanar estructuraPlanar = new EstructuraPlanar.EstructuraPlanarBuilder()
                .createBuzamientoIntensidad(buzamientoIntesidad.getText().toString())
                .createAzimut(!azimutTxt.isEmpty() ? Long.valueOf(azimutTxt) : 0)
                .createClivaje(clivaje.getText().toString())
                .createEstratificacion(estratificacion.getText().toString())
                .createFotogeologia(fotogeologia.getText().toString())
                .createZonaDeCizalla(zonaCizalla.getText().toString())
                .createRocasMetaforicas(rocasMetaforicas.getText().toString())
                .createRocasIgneas(rocasIgneas.getText().toString())
                .buid();
        mApiEstructuraPlanarAdapter.saveEstructuraPlanar(estructuraPlanar);
    }

    @Override
    public void estructuraPlanarReady(EstructuraPlanar estructuraPlanar) {}

    @Override
    public void estructuraPlanarSaved(String estructuraUrl) {
        fichaCampoLinks += getAbsUrl("estructuraPlanar", estructuraUrl) + ",\n";

        // Save estructura lineal
        String rumboTxt = rumboEstrLineal.getText().toString();
        String direccionTxt = direccion.getText().toString();
        EstructuraLineal estructuraLineal = new EstructuraLineal.EstructuraLinealBuilder()
                .createRumbo(!rumboTxt.isEmpty() ? Long.valueOf(rumboTxt) : 0)
                .createClaseEstrLineal(claseEstrLineal.getText().toString())
                .createLineacion(lineacion.getText().toString())
                .createDireccion(!direccionTxt.isEmpty() ? Long.valueOf(direccionTxt) : 0)
                .createBuzamiento(buzamientoEstrLineal.getText().toString())
                .createAsociacion(asociacion.getText().toString())
                .createFormacion(formacion.getText().toString())
                .createDiaclasaClase(diaclasaClase.getText().toString())
                .buid();
        mApiEstructuraLinealAdapter.saveEstructuraLineal(estructuraLineal);
    }

    @Override
    public void estructuraLinealReady(EstructuraLineal estructuraLineal) {}

    @Override
    public void estructuraLinealSaved(String estructuraUrl) {
        fichaCampoLinks += getAbsUrl("estructuraLineal", estructuraUrl) + ",\n";

        // Save pliegue
        String rumboTxt = rumboPliegue.getText().toString();
        String buzamientoTxt = buzamientoPliegue.getText().toString();
        String alturaTxt = altura.getText().toString();
        String separacionTxt = separacion.getText().toString();
        Pliegue pliegue = new Pliegue.PliegueBuilder()
                .createRumbo(!rumboTxt.isEmpty() ? Long.valueOf(rumboTxt) : 0)
                .createBuzamiento(!buzamientoTxt.isEmpty() ? Long.valueOf(buzamientoTxt) : 0)
                .createTipo(tipoPliegue.getText().toString())
                .createAltura(!alturaTxt.isEmpty() ? Long.valueOf(alturaTxt) : 0)
                .createSeparacion(!separacionTxt.isEmpty() ? Long.valueOf(separacionTxt) : 0)
                .createPosicion(posicion.getText().toString())
                .createAnguloEntreFlancos(anguloEntreFlancos.getText().toString())
                .createPerfil(perfil.getText().toString())
                .createSistema(sistema.getText().toString())
                .build();
        mApiPliegueAdapter.savePliegue(pliegue);
    }

    @Override
    public void pliegueReady(Pliegue pliegue) {}

    @Override
    public void pliegueSaved(String pliegueUrl) {
        fichaCampoLinks += getAbsUrl("pliegue", pliegueUrl) + ",\n";
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
}
