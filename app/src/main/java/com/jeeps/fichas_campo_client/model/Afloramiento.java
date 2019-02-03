package com.jeeps.fichas_campo_client.model;

public class Afloramiento {
    private String dimension;
    private String origen;
    private String tipoRoca;
    private String sitio;

    public Afloramiento() {
    }

    public Afloramiento(String dimension, String origen, String tipoRoca, String sitio) {
        this.dimension = dimension;
        this.origen = origen;
        this.tipoRoca = tipoRoca;
        this.sitio = sitio;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getTipoRoca() {
        return tipoRoca;
    }

    public void setTipoRoca(String tipoRoca) {
        this.tipoRoca = tipoRoca;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }
}


class AfloramientoBuilder{

    private Afloramiento afloramiento;

    public AfloramientoBuilder() {
    }

    public void build(){
        this.afloramiento = new Afloramiento();
    }

    public void createDimension(String dimension){
        this.afloramiento.setDimension(dimension);
    }

    public void createOrigen(String origen){
        this.afloramiento.setOrigen(origen);
    }

    public void createTipoRoca(String tipoRoca){
        this.afloramiento.setTipoRoca(tipoRoca);
    }

    public void createSitio(String sitio){
        this.afloramiento.setSitio(sitio);
    }

}