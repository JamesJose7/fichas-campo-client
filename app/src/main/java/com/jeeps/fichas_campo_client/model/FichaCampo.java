package com.jeeps.fichas_campo_client.model;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FichaCampo implements Serializable {
    private String datum;
    private String escala;
    private String proyecto;
    private String datosUbicacion;
    private String descritaPor;
    private String nomenclaturaUnidadGeologica;
    private String tipoContactoGeo;
    private String limiteContactoGeo;
    private String certezaContactoGeo;
    private String origenRoca;
    private String estructuraRoca;

    private Ubicacion ubicacion;

    // Estructuras Geologicas
    private EstructuraPlanar estructuraPlanar;
    private EstructuraLineal estructuraLineal;
    private Pliegue pliegue;

    // Catalogaciones
    private Muestra muestra;
    private Afloramiento afloramiento;

    @SerializedName("_links")
    private JsonObject selfLinks;

    public FichaCampo() { super(); }

    public FichaCampo(FichaCampoBuilder builder) {
        this.datum = builder.datum;
        this.escala = builder.escala;
        this.proyecto = builder.proyecto;
        this.datosUbicacion = builder.datosUbicacion;
        this.descritaPor = builder.descritaPor;
        this.nomenclaturaUnidadGeologica = builder.nomenclaturaUnidadGeologica;
        this.tipoContactoGeo = builder.tipoContactoGeo;
        this.limiteContactoGeo = builder.limiteContactoGeo;
        this.certezaContactoGeo = builder.certezaContactoGeo;
        this.origenRoca = builder.origenRoca;
        this.estructuraRoca = builder.estructuraRoca;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getDatosUbicacion() {
        return datosUbicacion;
    }

    public void setDatosUbicacion(String datosUbicacion) {
        this.datosUbicacion = datosUbicacion;
    }

    public String getDescritaPor() {
        return descritaPor;
    }

    public void setDescritaPor(String descritaPor) {
        this.descritaPor = descritaPor;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public EstructuraPlanar getEstructuraPlanar() {
        return estructuraPlanar;
    }

    public void setEstructuraPlanar(EstructuraPlanar estructuraPlanar) {
        this.estructuraPlanar = estructuraPlanar;
    }

    public EstructuraLineal getEstructuraLineal() {
        return estructuraLineal;
    }

    public void setEstructuraLineal(EstructuraLineal estructuraLineal) {
        this.estructuraLineal = estructuraLineal;
    }

    public Pliegue getPliegue() {
        return pliegue;
    }

    public void setPliegue(Pliegue pliegue) {
        this.pliegue = pliegue;
    }

    public Muestra getMuestra() {
        return muestra;
    }

    public void setMuestra(Muestra muestra) {
        this.muestra = muestra;
    }

    public Afloramiento getAfloramiento() {
        return afloramiento;
    }

    public void setAfloramiento(Afloramiento afloramiento) {
        this.afloramiento = afloramiento;
    }

    public String getNomenclaturaUnidadGeologica() {
        return nomenclaturaUnidadGeologica;
    }

    public void setNomenclaturaUnidadGeologica(String nomenclaturaUnidadGeologica) {
        this.nomenclaturaUnidadGeologica = nomenclaturaUnidadGeologica;
    }

    public String getTipoContactoGeo() {
        return tipoContactoGeo;
    }

    public void setTipoContactoGeo(String tipoContactoGeo) {
        this.tipoContactoGeo = tipoContactoGeo;
    }

    public String getLimiteContactoGeo() {
        return limiteContactoGeo;
    }

    public void setLimiteContactoGeo(String limiteContactoGeo) {
        this.limiteContactoGeo = limiteContactoGeo;
    }

    public String getCertezaContactoGeo() {
        return certezaContactoGeo;
    }

    public void setCertezaContactoGeo(String certezaContactoGeo) {
        this.certezaContactoGeo = certezaContactoGeo;
    }

    public String getOrigenRoca() {
        return origenRoca;
    }

    public void setOrigenRoca(String origenRoca) {
        this.origenRoca = origenRoca;
    }

    public String getEstructuraRoca() {
        return estructuraRoca;
    }

    public void setEstructuraRoca(String estructuraRoca) {
        this.estructuraRoca = estructuraRoca;
    }

    public JsonObject getSelfLinks() {
        return selfLinks;
    }

    public void setSelfLinks(JsonObject selfLinks) {
        this.selfLinks = selfLinks;
    }

    public static class FichaCampoBuilder{
        private String datum;
        private String escala;
        private String proyecto;
        private String datosUbicacion;
        private String descritaPor;
        private String nomenclaturaUnidadGeologica;
        private String tipoContactoGeo;
        private String limiteContactoGeo;
        private String certezaContactoGeo;
        private String origenRoca;
        private String estructuraRoca;

        private Ubicacion ubicacion;

        // Estructuras Geologicas
        private EstructuraPlanar estructuraPlanar;
        private EstructuraLineal estructuraLineal;
        private Pliegue pliegue;

        // Catalogaciones
        private Muestra muestra;
        private Afloramiento afloramiento;

        public FichaCampo build(){
            return new FichaCampo(this);
        }

        public FichaCampoBuilder createDatum(String datum){
            this.datum = datum;
            return this;
        }

        public FichaCampoBuilder createEscala(String escala){
            this.escala = escala;
            return this;
        }

        public FichaCampoBuilder createProyecto(String proyecto){
            this.proyecto = proyecto;
            return this;
        }

        public FichaCampoBuilder createDatosUbicacion(String datosUbicacion) {
            this.datosUbicacion = datosUbicacion;
            return this;
        }

        public FichaCampoBuilder createDescritaPor(String descritaPor){
            this.descritaPor = descritaPor;
            return this;
        }

        public FichaCampoBuilder createTipoContactoGeo(String tipoContactoGeo){
            this.tipoContactoGeo = tipoContactoGeo;
            return this;
        }

        public FichaCampoBuilder createLimiteContactoGeo(String limiteContactoGeo) {
            this.limiteContactoGeo = limiteContactoGeo;
            return this;
        }

        public FichaCampoBuilder createCertezaContactoGeo(String certezaContactoGeo) {
            this.certezaContactoGeo = certezaContactoGeo;
            return this;
        }

        public FichaCampoBuilder createUbicacion(Ubicacion ubicacion) {
            this.ubicacion = ubicacion;
            return this;
        }

        public FichaCampoBuilder createEstructuraPlanar(EstructuraPlanar estructuraPlanar) {
            this.estructuraPlanar = estructuraPlanar;
            return this;
        }

        public FichaCampoBuilder createEstructuraLineal(EstructuraLineal estructuraLineal) {
            this.estructuraLineal = estructuraLineal;
            return this;
        }

        public FichaCampoBuilder createPliegue(Pliegue pliegue) {
            this.pliegue = pliegue;
            return this;
        }

        public FichaCampoBuilder createMuestra(Muestra muestra) {
            this.muestra = muestra;
            return this;
        }

        public FichaCampoBuilder createAfloramiento(Afloramiento afloramiento) {
            this.afloramiento = afloramiento;
            return this;
        }
    }
}
