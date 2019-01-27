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

    public EstructuraPlanar(String buzamientoIntensidad, float azimut, String clivaje, String estratificacion,
                            String fotogeologia, String zonaDeCizalla, String rocasMetaforicas, String rocasIgneas) {
        this.buzamientoIntensidad = buzamientoIntensidad;
        this.azimut = azimut;
        this.clivaje = clivaje;
        this.estratificacion = estratificacion;
        this.fotogeologia = fotogeologia;
        this.zonaDeCizalla = zonaDeCizalla;
        this.rocasMetaforicas = rocasMetaforicas;
        this.rocasIgneas = rocasIgneas;
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
}
