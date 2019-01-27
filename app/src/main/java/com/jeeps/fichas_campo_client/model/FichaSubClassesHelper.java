package com.jeeps.fichas_campo_client.model;

import java.io.Serializable;

public class FichaSubClassesHelper implements Serializable {
    private String selfUrl;
    private String muestraUrl;
    private String estructuraPlanarUrl;
    private String ubicacionUrl;
    private String estructuraLinealUrl;
    private String afloramientoUrl;
    private String pliegueUrl;

    public String getSelfUrl() {
        return selfUrl;
    }

    public void setSelfUrl(String selfUrl) {
        this.selfUrl = selfUrl;
    }

    public String getMuestraUrl() {
        return muestraUrl;
    }

    public void setMuestraUrl(String muestraUrl) {
        this.muestraUrl = muestraUrl;
    }

    public String getEstructuraPlanarUrl() {
        return estructuraPlanarUrl;
    }

    public void setEstructuraPlanarUrl(String estructuraPlanarUrl) {
        this.estructuraPlanarUrl = estructuraPlanarUrl;
    }

    public String getUbicacionUrl() {
        return ubicacionUrl;
    }

    public void setUbicacionUrl(String ubicacionUrl) {
        this.ubicacionUrl = ubicacionUrl;
    }

    public String getEstructuraLinealUrl() {
        return estructuraLinealUrl;
    }

    public void setEstructuraLinealUrl(String estructuraLinealUrl) {
        this.estructuraLinealUrl = estructuraLinealUrl;
    }

    public String getAfloramientoUrl() {
        return afloramientoUrl;
    }

    public void setAfloramientoUrl(String afloramientoUrl) {
        this.afloramientoUrl = afloramientoUrl;
    }

    public String getPliegueUrl() {
        return pliegueUrl;
    }

    public void setPliegueUrl(String pliegueUrl) {
        this.pliegueUrl = pliegueUrl;
    }
}
