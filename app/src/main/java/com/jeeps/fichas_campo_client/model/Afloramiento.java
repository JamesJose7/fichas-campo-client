package com.jeeps.fichas_campo_client.model;

public class Afloramiento {
    private String dimension;
    private String origen;
    private String tipoRoca;
    private String sitio;

    public Afloramiento() {}

    public Afloramiento(AfloramientoBuilder builder) {
        this.dimension = builder.dimension;
        this.origen = builder.origen;
        this.tipoRoca = builder.tipoRoca;
        this.sitio = builder.sitio;
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

    public static class AfloramientoBuilder{
        private String dimension;
        private String origen;
        private String tipoRoca;
        private String sitio;

        public Afloramiento build(){
            return new Afloramiento(this);
        }

        public AfloramientoBuilder createDimension(String dimension){
            this.dimension = dimension;
            return this;
        }

        public AfloramientoBuilder createOrigen(String origen){
            this.origen = origen;
            return this;
        }

        public AfloramientoBuilder createTipoRoca(String tipoRoca){
            this.tipoRoca = tipoRoca;
            return this;
        }

        public AfloramientoBuilder createSitio(String sitio){
            this.sitio = sitio;
            return this;
        }

    }
}