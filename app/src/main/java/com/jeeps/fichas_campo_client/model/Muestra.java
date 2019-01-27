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

    public Muestra(String naturaleza, String tipo, String consistenciaMaterial, long codigo, String sitio,
                   String tipoAnalisis, String metodoAnalisis, String nomenclaturaMetodoAnalisis,
                   float cantidadMuestra, String observaciones) {
        this.naturaleza = naturaleza;
        this.tipo = tipo;
        this.consistenciaMaterial = consistenciaMaterial;
        this.codigo = codigo;
        this.sitio = sitio;
        this.tipoAnalisis = tipoAnalisis;
        this.metodoAnalisis = metodoAnalisis;
        this.nomenclaturaMetodoAnalisis = nomenclaturaMetodoAnalisis;
        this.cantidadMuestra = cantidadMuestra;
        this.observaciones = observaciones;
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
}
