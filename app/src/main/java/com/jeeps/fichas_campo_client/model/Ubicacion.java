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

    public Ubicacion(UbicacionBuilder builder) {
        this.fecha = builder.fecha;
        this.provincia = builder.provincia;
        this.canton = builder.canton;
        this.sector = builder.sector;
        this.escala = builder.escala;
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

    public static class UbicacionBuilder{
        private Date fecha;
        private String provincia;
        private String canton;
        private String sector;
        private String escala;
        private byte[] foto;

        public UbicacionBuilder() {}

        public Ubicacion build(){
            return new Ubicacion(this);
        }

        public UbicacionBuilder createFecha(Date fecha){
            this.fecha = fecha;
            return this;
        }

        public UbicacionBuilder createCanton(String canton){
            this.canton = canton;
            return this;
        }

        public UbicacionBuilder createProvincia(String provincia){
            this.provincia = provincia;
            return this;
        }

        public UbicacionBuilder createSector(String sector){
            this.sector = sector;
            return this;
        }

        public UbicacionBuilder createEscala(String escala){
            this.escala = escala;
            return this;
        }

        public UbicacionBuilder createFoto(byte[] foto){
            this.foto = foto;
            return this;
        }
    }
}
