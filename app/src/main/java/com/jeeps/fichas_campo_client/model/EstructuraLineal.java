package com.jeeps.fichas_campo_client.model;

public class EstructuraLineal {
    private float rumbo;
    private String claseEstrLineal;
    private String lineacion;
    // Diaclasa
    private float direccion;
    private String buzamiento;
    private String asociacion;
    private String formacion;
    private String diaclasaClase;

    public EstructuraLineal() {}

    public EstructuraLineal(EstructuraLinealBuilder builder) {
        this.rumbo = builder.rumbo;
        this.claseEstrLineal = builder.claseEstrLineal;
        this.lineacion = builder.lineacion;
        this.direccion = builder.direccion;
        this.buzamiento = builder.buzamiento;
        this.asociacion = builder.asociacion;
        this.formacion = builder.formacion;
        this.diaclasaClase = builder.diaclasaClase;
    }

    public float getRumbo() {
        return rumbo;
    }

    public void setRumbo(float rumbo) {
        this.rumbo = rumbo;
    }

    public String getClaseEstrLineal() {
        return claseEstrLineal;
    }

    public void setClaseEstrLineal(String claseEstrLineal) {
        this.claseEstrLineal = claseEstrLineal;
    }

    public String getLineacion() {
        return lineacion;
    }

    public void setLineacion(String lineacion) {
        this.lineacion = lineacion;
    }

    public float getDireccion() {
        return direccion;
    }

    public void setDireccion(float direccion) {
        this.direccion = direccion;
    }

    public String getBuzamiento() {
        return buzamiento;
    }

    public void setBuzamiento(String buzamiento) {
        this.buzamiento = buzamiento;
    }

    public String getAsociacion() {
        return asociacion;
    }

    public void setAsociacion(String asociacion) {
        this.asociacion = asociacion;
    }

    public String getFormacion() {
        return formacion;
    }

    public void setFormacion(String formacion) {
        this.formacion = formacion;
    }

    public String getDiaclasaClase() {
        return diaclasaClase;
    }

    public void setDiaclasaClase(String diaclasaClase) {
        this.diaclasaClase = diaclasaClase;
    }

    public static class EstructuraLinealBuilder{
        private float rumbo;
        private String claseEstrLineal;
        private String lineacion;
        // Diaclasa
        private float direccion;
        private String buzamiento;
        private String asociacion;
        private String formacion;
        private String diaclasaClase;

        public EstructuraLinealBuilder(){}

        public EstructuraLineal buid(){
            return new EstructuraLineal(this);
        }

        public EstructuraLinealBuilder createClaseEstrLineal(String claseEstrLineal){
            this.claseEstrLineal = claseEstrLineal;
            return this;
        }

        public EstructuraLinealBuilder createRumbo(float rumbo){
            this.rumbo = rumbo;
            return this;
        }

        public EstructuraLinealBuilder createLineacion(String lineacion){
            this.lineacion = lineacion;
            return this;
        }

        public EstructuraLinealBuilder createDireccion(float direccion){
            this.direccion = direccion;
            return this;
        }

        public EstructuraLinealBuilder createBuzamiento(String buzamiento){
            this.buzamiento = buzamiento;
            return this;
        }

        public EstructuraLinealBuilder createAsociacion(String asociacion){
            this.asociacion = asociacion;
            return this;
        }

        public EstructuraLinealBuilder createFormacion(String formacion){
            this.formacion = formacion;
            return this;
        }

        public EstructuraLinealBuilder createDiaclasaClase(String diaclasaClase){
            this.diaclasaClase = diaclasaClase;
            return this;
        }
    }
}
