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

class EstructuraLinealBuilder{


    private EstructuraLineal estructuraLineal;

    public EstructuraLinealBuilder(){}

    public void buid(){
        this.estructuraLineal = new EstructuraLineal();
    }

    public void createClaseEstrLineal(String claseEstrLineal){
        this.estructuraLineal.setClaseEstrLineal(claseEstrLineal);
    }

    public void createRumbo(float rumbo){
        this.estructuraLineal.setRumbo(rumbo);
    }

    public void createLineacion(String lineacion){
        this.estructuraLineal.setLineacion(lineacion);
    }

    public void createDireccion(float direccion){
        this.estructuraLineal.setDireccion(direccion);
    }

    public void createBuzamiento(String buzamiento){
        this.estructuraLineal.setBuzamiento(buzamiento);
    }

    public void createAsociacion(String asociacion){
        this.estructuraLineal.setAsociacion(asociacion);
    }

    public void createFormacion(String formacion){
        this.estructuraLineal.setAsociacion(formacion);
    }

    public void createDiaclasaClase(String diaclasaClase){
        this.estructuraLineal.setDiaclasaClase(diaclasaClase);
    }

}
