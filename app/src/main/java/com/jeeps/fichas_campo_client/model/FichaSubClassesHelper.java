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

    public FichaSubClassesHelper() {}

    public FichaSubClassesHelper(FichaSubClassesHelperBuilder builder) {
        this.selfUrl = builder.selfUrl;
        this.muestraUrl = builder.muestraUrl;
        this.estructuraPlanarUrl = builder.estructuraPlanarUrl;
        this.ubicacionUrl = builder.ubicacionUrl;
        this.estructuraLinealUrl = builder.estructuraLinealUrl;
        this.afloramientoUrl = builder.afloramientoUrl;
        this.pliegueUrl = builder.pliegueUrl;
    }

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

    public static class FichaSubClassesHelperBuilder{
        private String selfUrl;
        private String muestraUrl;
        private String estructuraPlanarUrl;
        private String ubicacionUrl;
        private String estructuraLinealUrl;
        private String afloramientoUrl;
        private String pliegueUrl;

        public FichaSubClassesHelperBuilder() {}

        public FichaSubClassesHelper build(){
            return new FichaSubClassesHelper(this);
        }

        public FichaSubClassesHelperBuilder createSelfUrl(String selfUrl){
            this.selfUrl = selfUrl;
            return this;
        }

        public FichaSubClassesHelperBuilder createMuestraUrl(String muestraUrl){
            this.muestraUrl = muestraUrl;
            return this;
        }

        public FichaSubClassesHelperBuilder createEstructuraPlanarUrl(String estructuraPlanarUrl){
            this.estructuraPlanarUrl = estructuraPlanarUrl;
            return this;
        }

        public FichaSubClassesHelperBuilder createUbicacionUrl(String ubicacionUrl){
            this.ubicacionUrl = ubicacionUrl;
            return this;
        }

        public FichaSubClassesHelperBuilder createEstructuraLinealUrl(String estructuraLinealUrl){
            this.estructuraLinealUrl = estructuraLinealUrl;
            return this;
        }

        public FichaSubClassesHelperBuilder createAfloramientoUrl(String afloramientoUrl){
            this.afloramientoUrl = afloramientoUrl;
            return this;
        }

        public FichaSubClassesHelperBuilder createPliegueUrl(String pliegueUrl){
            this.pliegueUrl = pliegueUrl;
            return this;
        }
    }
}
