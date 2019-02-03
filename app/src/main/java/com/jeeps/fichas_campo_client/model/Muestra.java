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

class MuestraBuilder{

    private Muestra muestra;

    public MuestraBuilder() {
    }

    public void build(){
        this.muestra = new Muestra();
    }

    public void createNaturaleza(String naturaleza){
        this.muestra.setNaturaleza(naturaleza);
    }

    public void createTipo(String tipo){
        this.muestra.setTipo(tipo);
    }

    public void createConsistenciaMaterial(String consistenciaMaterial){
        this.muestra.setConsistenciaMaterial(consistenciaMaterial);
    }

    public void createCodigo(long codigo){
        this.muestra.setCodigo(codigo);
    }

    public void createSitio(String sitio){
        this.muestra.setSitio(sitio);
    }

    public void createTipoAnalisis(String tipoAnalisis){
        this.muestra.setTipoAnalisis(tipoAnalisis);
    }

    public void createMetodoAnalisis(String metodoAnalisis){
        this.muestra.setMetodoAnalisis(metodoAnalisis);
    }

    public void createNomenclaturaMetodoAnalisis(String nomenclaturaMetodoAnalisis){
        this.muestra.setNomenclaturaMetodoAnalisis(nomenclaturaMetodoAnalisis);
    }

    public void createCantidadMuestra(float cantidadMuestra){
        this.muestra.setCantidadMuestra(cantidadMuestra);
    }

    public void createObservaciones(String observaciones) {
        this.muestra.setObservaciones(observaciones);
    }
}
