package com.jeeps.fichas_campo_client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jeeps.fichas_campo_client.adapters.ApiAfloramientoAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiEstructuraLinealAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiEstructuraPlanarAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiMuestraAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiPliegueAdapter;
import com.jeeps.fichas_campo_client.adapters.ApiUbicacionAdapter;
import com.jeeps.fichas_campo_client.adapters.FichaCampoRecyclerViewAdapter;
import com.jeeps.fichas_campo_client.model.Afloramiento;
import com.jeeps.fichas_campo_client.model.EstructuraLineal;
import com.jeeps.fichas_campo_client.model.EstructuraPlanar;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.FichaSubClassesHelper;
import com.jeeps.fichas_campo_client.model.Muestra;
import com.jeeps.fichas_campo_client.model.Pliegue;
import com.jeeps.fichas_campo_client.model.Ubicacion;

import java.text.SimpleDateFormat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FichaDetailsActivity extends AppCompatActivity implements
        ApiUbicacionAdapter.ApiUbicacionListener,
        ApiPliegueAdapter.ApiPliegueListener,
        ApiMuestraAdapter.ApiMuestraListener,
        ApiEstructuraPlanarAdapter.ApiEstructuraPlanarListener,
        ApiEstructuraLinealAdapter.ApiEstructuraLinealListener,
        ApiAfloramientoAdapter.ApiAfloramientoListener {

    private ApiUbicacionAdapter mApiUbicacionAdapter;
    private ApiPliegueAdapter mApiPliegueAdapter;
    private ApiMuestraAdapter mApiMuestraAdapter;
    private ApiEstructuraPlanarAdapter mApiEstructuraPlanarAdapter;
    private ApiEstructuraLinealAdapter mApiEstructuraLinealAdapter;
    private  ApiAfloramientoAdapter mApiAfloramientoAdapter;

    // Ficha de campo
    @BindView(R.id.datum_text) TextView datum;
    @BindView(R.id.escala_text) TextView escala;
    @BindView(R.id.proyecto_text) TextView proyecto;
    @BindView(R.id.datos_ubicacion_text) TextView datosUbicacion;
    @BindView(R.id.descrita_por_text) TextView descritaPor;
    @BindView(R.id.nom_unidad_geo_text) TextView nomUnidadGeologica;
    @BindView(R.id.tipo_contacto_text) TextView tipoContacto;
    @BindView(R.id.limite_contacto_text) TextView limiteContacto;
    @BindView(R.id.certeza_contacto_text) TextView certezaContacto;
    @BindView(R.id.origen_roca_text) TextView origenRoca;
    @BindView(R.id.estructura_roca_text) TextView estructuraRoca;

    // Ubicacion
    @BindView(R.id.fecha_text) TextView fecha;
    @BindView(R.id.provincia_text) TextView provincia;
    @BindView(R.id.canton_text) TextView canton;
    @BindView(R.id.sector_text) TextView sector;
    @BindView(R.id.escala_ubicacion_text) TextView escalaUbicacion;
    @BindView(R.id.foto_ubicacion) ImageView foto;

    // Muestra
    @BindView(R.id.naturaleza_text) TextView naturaleza;
    @BindView(R.id.tipo_muestra_text) TextView tipoMuestra;
    @BindView(R.id.consistencia_material_text) TextView consistenciaMaterial;
    @BindView(R.id.codigo_text) TextView codigo;
    @BindView(R.id.sitio_muestra_text) TextView sitioMuestra;
    @BindView(R.id.tipo_analisis_text) TextView tipoAnalisis;
    @BindView(R.id.metodo_analisis_text) TextView metodoAnalisis;
    @BindView(R.id.nom_metodo_analisis_text) TextView nomMetodoAnalisis;
    @BindView(R.id.cantidad_muestra_text) TextView cantidadMuestra;
    @BindView(R.id.observaciones_text) TextView observaciones;

    // Afloramiento
    @BindView(R.id.dimension_text) TextView dimension;
    @BindView(R.id.origen_afloramiento_text) TextView origenAfloramiento;
    @BindView(R.id.tipo_roca_text) TextView tipoRoca;
    @BindView(R.id.sitio_afloramiento_text) TextView sitioAfloramiento;

    // Estructura Planar
    @BindView(R.id.buz_intensidad_text) TextView buzamientoIntesidad;
    @BindView(R.id.azimut_text) TextView azimut;
    @BindView(R.id.clivaje_text) TextView clivaje;
    @BindView(R.id.estratificacion_text) TextView estratificacion;
    @BindView(R.id.fotogeologia_text) TextView fotogeologia;
    @BindView(R.id.zona_cizalla_text) TextView zonaCizalla;
    @BindView(R.id.rocas_metaforicas_text) TextView rocasMetaforicas;
    @BindView(R.id.rocas_igneas_text) TextView rocasIgneas;

    // Estructura Linear
    @BindView(R.id.rumbo_estr_lineal_text) TextView rumboEstrLineal;
    @BindView(R.id.clase_estr_lineal_text) TextView claseEstrLineal;
    @BindView(R.id.lineacion_text) TextView lineacion;
    @BindView(R.id.direccion_text) TextView direccion;
    @BindView(R.id.buzamiento_estr_lineal_text) TextView buzamientoEstrLineal;
    @BindView(R.id.asociacion_text) TextView asociacion;
    @BindView(R.id.formacion_text) TextView formacion;
    @BindView(R.id.diaclasa_clase_text) TextView diaclasaClase;

    // Pliegue
    @BindView(R.id.rumbo_pliegue_text) TextView rumboPliegue;
    @BindView(R.id.buzamiento_pliegue_text) TextView buzamientoPliegue;
    @BindView(R.id.tipo_pliegue_text) TextView tipoPliegue;
    @BindView(R.id.altura_text) TextView altura;
    @BindView(R.id.separacion_text) TextView separacion;
    @BindView(R.id.posicion_text) TextView posicion;
    @BindView(R.id.angulo_flancos_text) TextView anguloEntreFlancos;
    @BindView(R.id.perfil_text) TextView perfil;
    @BindView(R.id.sistema_text) TextView sistema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_detailes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Get Ficha de campo and subclasses url from intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        FichaCampo fichaCampo =
                (FichaCampo) bundle.getSerializable(FichaCampoRecyclerViewAdapter.SERIALIZED_FICHA);
        FichaSubClassesHelper fichaSubClassesHelper =
                (FichaSubClassesHelper) bundle.getSerializable(FichaCampoRecyclerViewAdapter.SERIALIZED_FICHA_SUB);

        // Set datos Ficha de campo
        datum.setText(fichaCampo.getDatum());
        escala.setText(fichaCampo.getEscala());
        proyecto.setText(fichaCampo.getProyecto());
        datosUbicacion.setText(fichaCampo.getDatosUbicacion());
        descritaPor.setText(fichaCampo.getDescritaPor());
        nomUnidadGeologica.setText(fichaCampo.getNomenclaturaUnidadGeologica());
        tipoContacto.setText(fichaCampo.getTipoContactoGeo());
        limiteContacto.setText(fichaCampo.getLimiteContactoGeo());
        certezaContacto.setText(fichaCampo.getCertezaContactoGeo());
        origenRoca.setText(fichaCampo.getOrigenRoca());
        estructuraRoca.setText(fichaCampo.getEstructuraRoca());

        // Request ubicacion
        mApiUbicacionAdapter = new ApiUbicacionAdapter(this);
        mApiUbicacionAdapter.requestUbicacion(fichaSubClassesHelper.getUbicacionUrl());
        // Request pliegue
        mApiPliegueAdapter = new ApiPliegueAdapter(this);
        mApiPliegueAdapter.requestPliegue(fichaSubClassesHelper.getPliegueUrl());
        // Request muestra
        mApiMuestraAdapter = new ApiMuestraAdapter(this);
        mApiMuestraAdapter.requestMuestra(fichaSubClassesHelper.getMuestraUrl());
        // Request Estructura planar
        mApiEstructuraPlanarAdapter = new ApiEstructuraPlanarAdapter(this);
        mApiEstructuraPlanarAdapter.requestEstructuraPlanar(fichaSubClassesHelper.getEstructuraPlanarUrl());
        // Request estructura lineal
        mApiEstructuraLinealAdapter = new ApiEstructuraLinealAdapter(this);
        mApiEstructuraLinealAdapter.requestEstructuraLineal(fichaSubClassesHelper.getEstructuraLinealUrl());
        // Request afloramiento
        mApiAfloramientoAdapter = new ApiAfloramientoAdapter(this);
        mApiAfloramientoAdapter.requestAfloramiento(fichaSubClassesHelper.getAfloramientoUrl());
    }

    @Override
    public void ubicacionReady(Ubicacion ubicacion) {
        runOnUiThread(() -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            fecha.setText(dateFormat.format(ubicacion.getFecha()));
            provincia.setText(ubicacion.getProvincia());
            canton.setText(ubicacion.getCanton());
            sector.setText(ubicacion.getSector());
            escala.setText(ubicacion.getEscala());
        });
    }

    @Override
    public void afloramientoReady(Afloramiento afloramiento) {
        runOnUiThread(() -> {
            dimension.setText(afloramiento.getDimension());
            origenAfloramiento.setText(afloramiento.getOrigen());
            tipoRoca.setText(afloramiento.getTipoRoca());
            sitioAfloramiento.setText(afloramiento.getSitio());
        });
    }

    @Override
    public void estructuraLinealReady(EstructuraLineal estructuraLineal) {
        runOnUiThread(() -> {
            rumboEstrLineal.setText(estructuraLineal.getRumbo() + "");
            claseEstrLineal.setText(estructuraLineal.getClaseEstrLineal());
            lineacion.setText(estructuraLineal.getLineacion());
            direccion.setText(estructuraLineal.getDireccion() + "");
            buzamientoEstrLineal.setText(estructuraLineal.getBuzamiento());
            asociacion.setText(estructuraLineal.getAsociacion());
            formacion.setText(estructuraLineal.getFormacion());
            diaclasaClase.setText(estructuraLineal.getDiaclasaClase());
        });
    }

    @Override
    public void estructuraPlanarReady(EstructuraPlanar estructuraPlanar) {
        runOnUiThread(() -> {
            buzamientoIntesidad.setText(estructuraPlanar.getBuzamientoIntensidad());
            azimut.setText(estructuraPlanar.getAzimut() + "");
            clivaje.setText(estructuraPlanar.getClivaje());
            estratificacion.setText(estructuraPlanar.getEstratificacion());
            fotogeologia.setText(estructuraPlanar.getFotogeologia());
            zonaCizalla.setText(estructuraPlanar.getZonaDeCizalla());
            rocasMetaforicas.setText(estructuraPlanar.getRocasIgneas());
            rocasIgneas.setText(estructuraPlanar.getRocasIgneas());
        });
    }

    @Override
    public void muestraReady(Muestra muestra) {
        runOnUiThread(() -> {
            naturaleza.setText(muestra.getNaturaleza());
            tipoMuestra.setText(muestra.getTipo());
            consistenciaMaterial.setText(muestra.getTipo());
            codigo.setText(muestra.getCodigo() + "");
            sitioMuestra.setText(muestra.getSitio());
            tipoAnalisis.setText(muestra.getTipoAnalisis());
            metodoAnalisis.setText(muestra.getMetodoAnalisis());
            nomMetodoAnalisis.setText(muestra.getMetodoAnalisis());
            cantidadMuestra.setText(muestra.getCantidadMuestra() + "");
            observaciones.setText(muestra.getObservaciones());
        });
    }

    @Override
    public void pliegueReady(Pliegue pliegue) {
        runOnUiThread(() -> {
            rumboPliegue.setText(pliegue.getRumbo() + "");
            buzamientoPliegue.setText(pliegue.getBuzamiento() + "");
            tipoPliegue.setText(pliegue.getTipo());
            altura.setText(pliegue.getAltura() + "");
            separacion.setText(pliegue.getSeparacion() + "");
            posicion.setText(pliegue.getPosicion());
            anguloEntreFlancos.setText(pliegue.getAnguloEntreFlancos());
            perfil.setText(pliegue.getPerfil());
            sistema.setText(pliegue.getSistema());
        });
    }
}
