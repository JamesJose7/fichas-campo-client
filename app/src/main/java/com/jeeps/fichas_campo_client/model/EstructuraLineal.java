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

    public EstructuraLineal() {
    }

    public EstructuraLineal(float rumbo, String claseEstrLineal, String lineacion, float direccion, String buzamiento,
                            String asociacion, String formacion, String diaclasaClase) {
        this.rumbo = rumbo;
        this.claseEstrLineal = claseEstrLineal;
        this.lineacion = lineacion;
        this.direccion = direccion;
        this.buzamiento = buzamiento;
        this.asociacion = asociacion;
        this.formacion = formacion;
        this.diaclasaClase = diaclasaClase;
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
}
