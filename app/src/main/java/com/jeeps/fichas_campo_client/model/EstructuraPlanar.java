package com.jeeps.fichas_campo_client.model;

public class EstructuraPlanar {
    private String buzamientoIntensidad;
    private float azimut;
    private String clivaje;
    private String estratificacion;
    private String fotogeologia;
    private String zonaDeCizalla;
    // Foliacion
    private String rocasMetaforicas;
    private String rocasIgneas;

    public EstructuraPlanar() {
    }

    public EstructuraPlanar(EstructuraPlanarBuilder builder) {
        this.buzamientoIntensidad = builder.buzamientoIntensidad;
        this.azimut = builder.azimut;
        this.clivaje = builder.clivaje;
        this.estratificacion = builder.estratificacion;
        this.fotogeologia = builder.fotogeologia;
        this.zonaDeCizalla = builder.zonaDeCizalla;
        this.rocasMetaforicas = builder.rocasMetaforicas;
        this.rocasIgneas = builder.rocasIgneas;
    }

    public String getBuzamientoIntensidad() {
        return buzamientoIntensidad;
    }

    public void setBuzamientoIntensidad(String buzamientoIntensidad) {
        this.buzamientoIntensidad = buzamientoIntensidad;
    }

    public float getAzimut() {
        return azimut;
    }

    public void setAzimut(float azimut) {
        this.azimut = azimut;
    }

    public String getClivaje() {
        return clivaje;
    }

    public void setClivaje(String clivaje) {
        this.clivaje = clivaje;
    }

    public String getEstratificacion() {
        return estratificacion;
    }

    public void setEstratificacion(String estratificacion) {
        this.estratificacion = estratificacion;
    }

    public String getFotogeologia() {
        return fotogeologia;
    }

    public void setFotogeologia(String fotogeologia) {
        this.fotogeologia = fotogeologia;
    }

    public String getZonaDeCizalla() {
        return zonaDeCizalla;
    }

    public void setZonaDeCizalla(String zonaDeCizalla) {
        this.zonaDeCizalla = zonaDeCizalla;
    }

    public String getRocasMetaforicas() {
        return rocasMetaforicas;
    }

    public void setRocasMetaforicas(String rocasMetaforicas) {
        this.rocasMetaforicas = rocasMetaforicas;
    }

    public String getRocasIgneas() {
        return rocasIgneas;
    }

    public void setRocasIgneas(String rocasIgneas) {
        this.rocasIgneas = rocasIgneas;
    }

    public static class EstructuraPlanarBuilder{
        private String buzamientoIntensidad;
        private float azimut;
        private String clivaje;
        private String estratificacion;
        private String fotogeologia;
        private String zonaDeCizalla;
        // Foliacion
        private String rocasMetaforicas;
        private String rocasIgneas;

        public EstructuraPlanarBuilder(){}

        public EstructuraPlanar buid(){
            return new EstructuraPlanar(this);
        }

        public EstructuraPlanarBuilder createBuzamientoIntensidad(String buzamientoIntensidad){
            this.buzamientoIntensidad = buzamientoIntensidad;
            return this;
        }

        public EstructuraPlanarBuilder createAzimut(float azimut){
            this.azimut = azimut;
            return this;
        }

        public EstructuraPlanarBuilder createClivaje(String clivaje){
            this.clivaje = clivaje;
            return this;
        }

        public EstructuraPlanarBuilder createEstratificacion(String estratificacion){
            this.estratificacion = estratificacion;
            return this;
        }

        public EstructuraPlanarBuilder createFotogeologia(String fotogeologia){
            this.fotogeologia = fotogeologia;
            return this;
        }

        public EstructuraPlanarBuilder createZonaDeCizalla(String zonaDeCizalla){
            this.zonaDeCizalla = zonaDeCizalla;
            return this;
        }

        public EstructuraPlanarBuilder createRocasMetaforicas(String rocasMetaforicas){
            this.rocasMetaforicas = rocasMetaforicas;
            return this;
        }

        public EstructuraPlanarBuilder createRocasIgneas(String rocasIgneas){
            this.rocasIgneas = rocasIgneas;
            return this;
        }
    }
}


