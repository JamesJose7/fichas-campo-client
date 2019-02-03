package com.jeeps.fichas_campo_client.model;

public class Pliegue {
    private float rumbo;
    private float buzamiento;
    private String tipo;
    private float altura;
    private float separacion;
    private String posicion;
    private String anguloEntreFlancos;
    private String perfil;
    private String sistema;

    public Pliegue() {
    }

    public Pliegue(PliegueBuilder builder) {
        this.rumbo = builder.rumbo;
        this.buzamiento = builder.buzamiento;
        this.tipo = builder.tipo;
        this.altura = builder.altura;
        this.separacion = builder.separacion;
        this.posicion = builder.posicion;
        this.anguloEntreFlancos = builder.anguloEntreFlancos;
        this.perfil = builder.perfil;
        this.sistema = builder.sistema;
    }

    public float getRumbo() {
        return rumbo;
    }

    public void setRumbo(float rumbo) {
        this.rumbo = rumbo;
    }

    public float getBuzamiento() {
        return buzamiento;
    }

    public void setBuzamiento(float buzamiento) {
        this.buzamiento = buzamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getSeparacion() {
        return separacion;
    }

    public void setSeparacion(float separacion) {
        this.separacion = separacion;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getAnguloEntreFlancos() {
        return anguloEntreFlancos;
    }

    public void setAnguloEntreFlancos(String anguloEntreFlancos) {
        this.anguloEntreFlancos = anguloEntreFlancos;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public static class PliegueBuilder{
        private float rumbo;
        private float buzamiento;
        private String tipo;
        private float altura;
        private float separacion;
        private String posicion;
        private String anguloEntreFlancos;
        private String perfil;
        private String sistema;

        public PliegueBuilder() {}

        public Pliegue build(){
            return new Pliegue(this);
        }

        public PliegueBuilder createRumbo(float rumbo){
            return this;
        }

        public PliegueBuilder createBuzamiento(float buzamiento){
            return this;
        }

        public PliegueBuilder createTipo(String tipo){
            return this;
        }

        public PliegueBuilder createAltura(float altura){
            return this;
        }

        public PliegueBuilder createSeparacion(float separacion){
            return this;
        }

        public PliegueBuilder createAnguloEntreFlancos(String anguloEntreFlancos){
            return this;
        }

        public PliegueBuilder createPerfil(String perfil){
            return this;
        }

        public PliegueBuilder createSistema(String sistema){
            return this;
        }
    }
}
