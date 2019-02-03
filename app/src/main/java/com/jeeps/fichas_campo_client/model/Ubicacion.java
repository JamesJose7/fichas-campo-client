package com.jeeps.fichas_campo_client.model;

import java.util.Date;

public class Ubicacion {
    private Date fecha;
    private String provincia;
    private String canton;
    private String sector;
    private String escala;
    private byte[] foto;

    public Ubicacion() { super(); }

    public Ubicacion(Date fecha, String provincia, String canton, String sector, String escala) {
        this.fecha = fecha;
        this.provincia = provincia;
        this.canton = canton;
        this.sector = sector;
        this.escala = escala;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getEscala() {
        return escala;
    }

    public void setEscala(String escala) {
        this.escala = escala;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}

class UbicacionBuilder{

    private Ubicacion ubicacion;

    public UbicacionBuilder() {
    }

    public void build(){
        this.ubicacion = new Ubicacion();
    }

    public void createFecha(){
        Date date = new Date();
        this.ubicacion.setFecha(date);
    }

    public void createCanton(String canton){
        this.ubicacion.setCanton(canton);
    }

    public void createProvincia(String provincia){
        this.ubicacion.setProvincia(provincia);
    }

    public void createSector(String sector){
        this.ubicacion.setSector(sector);
    }

    public void createEscala(String escala){
        this.ubicacion.setEscala(escala);
    }

    public void createFoto(byte[] foto){
        this.ubicacion.setFoto(foto);
    }

    public Ubicacion getUbicacion(){ return this.ubicacion; }

}
