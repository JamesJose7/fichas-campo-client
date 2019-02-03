package com.jeeps.fichas_campo_client.model;

public class Muestra {
    private String naturaleza;
    private String tipo;
    private String consistenciaMaterial;
    private long codigo;
    private String sitio;
    private String tipoAnalisis;
    private String metodoAnalisis;
    private String nomenclaturaMetodoAnalisis;
    private float cantidadMuestra;
    private String observaciones;

    public Muestra() {
    }

    public Muestra(MuestraBuilder builder) {
        this.naturaleza = builder.naturaleza;
        this.tipo = builder.tipo;
        this.consistenciaMaterial = builder.consistenciaMaterial;
        this.codigo = builder.codigo;
        this.sitio = builder.sitio;
        this.tipoAnalisis = builder.tipoAnalisis;
        this.metodoAnalisis = builder.metodoAnalisis;
        this.nomenclaturaMetodoAnalisis = builder.nomenclaturaMetodoAnalisis;
        this.cantidadMuestra = builder.cantidadMuestra;
        this.observaciones = builder.observaciones;
    }

    public String getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(String naturaleza) {
        this.naturaleza = naturaleza;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getConsistenciaMaterial() {
        return consistenciaMaterial;
    }

    public void setConsistenciaMaterial(String consistenciaMaterial) {
        this.consistenciaMaterial = consistenciaMaterial;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getSitio() {
        return sitio;
    }

    public void setSitio(String sitio) {
        this.sitio = sitio;
    }

    public String getTipoAnalisis() {
        return tipoAnalisis;
    }

    public void setTipoAnalisis(String tipoAnalisis) {
        this.tipoAnalisis = tipoAnalisis;
    }

    public String getMetodoAnalisis() {
        return metodoAnalisis;
    }

    public void setMetodoAnalisis(String metodoAnalisis) {
        this.metodoAnalisis = metodoAnalisis;
    }

    public String getNomenclaturaMetodoAnalisis() {
        return nomenclaturaMetodoAnalisis;
    }

    public void setNomenclaturaMetodoAnalisis(String nomenclaturaMetodoAnalisis) {
        this.nomenclaturaMetodoAnalisis = nomenclaturaMetodoAnalisis;
    }

    public float getCantidadMuestra() {
        return cantidadMuestra;
    }

    public void setCantidadMuestra(float cantidadMuestra) {
        this.cantidadMuestra = cantidadMuestra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public static class MuestraBuilder{
        private String naturaleza;
        private String tipo;
        private String consistenciaMaterial;
        private long codigo;
        private String sitio;
        private String tipoAnalisis;
        private String metodoAnalisis;
        private String nomenclaturaMetodoAnalisis;
        private float cantidadMuestra;
        private String observaciones;

        public Muestra build(){
            return new Muestra();
        }

        public MuestraBuilder createNaturaleza(String naturaleza){
            this.naturaleza = naturaleza;
            return this;
        }

        public MuestraBuilder createTipo(String tipo){
            this.tipo = tipo;
            return this;
        }

        public MuestraBuilder createConsistenciaMaterial(String consistenciaMaterial){
            this.consistenciaMaterial = consistenciaMaterial;
            return this;
        }

        public MuestraBuilder createCodigo(long codigo){
            this.codigo = codigo;
            return this;
        }

        public MuestraBuilder createSitio(String sitio){
            this.sitio = sitio;
            return this;
        }

        public MuestraBuilder createTipoAnalisis(String tipoAnalisis){
            this.tipoAnalisis = tipoAnalisis;
            return this;
        }

        public MuestraBuilder createMetodoAnalisis(String metodoAnalisis){
            this.metodoAnalisis = metodoAnalisis;
            return this;
        }

        public MuestraBuilder createNomenclaturaMetodoAnalisis(String nomenclaturaMetodoAnalisis){
            this.nomenclaturaMetodoAnalisis = nomenclaturaMetodoAnalisis;
            return this;
        }

        public MuestraBuilder createCantidadMuestra(float cantidadMuestra){
            this.cantidadMuestra = cantidadMuestra;
            return this;
        }

        public MuestraBuilder createObservaciones(String observaciones) {
            this.observaciones = observaciones;
            return this;
        }
    }
}