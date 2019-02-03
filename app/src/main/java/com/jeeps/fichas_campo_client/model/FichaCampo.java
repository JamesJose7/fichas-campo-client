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

    public FichaCampo(String datum, String escala, String proyecto, String datosUbicacion, String descritaPor,
                      String nomenclaturaUnidadGeologica, String tipoContactoGeo, String limiteContactoGeo,
                      String certezaContactoGeo, String origenRoca, String estructuraRoca) {
        this.datum = datum;
        this.escala = escala;
        this.proyecto = proyecto;
        this.datosUbicacion = datosUbicacion;
        this.descritaPor = descritaPor;
        this.nomenclaturaUnidadGeologica = nomenclaturaUnidadGeologica;
        this.tipoContactoGeo = tipoContactoGeo;
        this.limiteContactoGeo = limiteContactoGeo;
        this.certezaContactoGeo = certezaContactoGeo;
        this.origenRoca = origenRoca;
        this.estructuraRoca = estructuraRoca;
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
}

class FichaCampoBuilder{


    private FichaCampo fichaCampo;

    public FichaCampoBuilder(Muestra muestra, Afloramiento afloramiento, String origenRoca, String estructuraRoca, String nomenclaturaUnidadGeologica) {
        this.fichaCampo.setMuestra(muestra);
        this.fichaCampo.setAfloramiento(afloramiento);
        this.fichaCampo.setOrigenRoca(origenRoca);
        this.fichaCampo.setEstructuraRoca(estructuraRoca);
        this.fichaCampo.setNomenclaturaUnidadGeologica(nomenclaturaUnidadGeologica);
    }

    public void build(){
        this.fichaCampo = new FichaCampo();
    }

    public void createDatum(String datum){
        this.fichaCampo.setDatum(datum);
    }

    public void createEscala(String escala){
        this.fichaCampo.setEscala(escala);
    }

    public void createProyecto(String proyecto){
        this.fichaCampo.setProyecto(proyecto);
    }

    public void createDatosUbicacion(String datosUbicacion){
        this.fichaCampo.setDatosUbicacion(datosUbicacion);
    }

    public void createDescritaPor(String descritaPor){
        this.fichaCampo.setDescritaPor(descritaPor);
    }

    public void createTipoContactoGeo(String tipoContactoGeo){
        this.fichaCampo.setTipoContactoGeo(tipoContactoGeo);
    }

    public void createLimiteContactoGeo(String limiteContactoGeo) {
        this.fichaCampo.setLimiteContactoGeo(limiteContactoGeo);
    }

    public void createCertezaContactoGeo(String certezaContactoGeo) {
        this.fichaCampo.setCertezaContactoGeo(certezaContactoGeo);
    }

    public void createEstructuraPlanar(EstructuraPlanar estructuraPlanar) {
        this.fichaCampo.setEstructuraPlanar(estructuraPlanar);
    }

    public void createEstructuraLineal(EstructuraLineal estructuraLineal) {
        this.fichaCampo.setEstructuraLineal(estructuraLineal);
    }

    public void createPliegue(Pliegue pliegue) {
        this.fichaCampo.setPliegue(pliegue);
    }

    public FichaCampo getFichaCampo(){ return this.fichaCampo;}
}
