package com.jeeps.fichas_campo_client.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jeeps.fichas_campo_client.model.Afloramiento;
import com.jeeps.fichas_campo_client.model.EstructuraLineal;
import com.jeeps.fichas_campo_client.model.EstructuraPlanar;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.FichaSubClassesHelper;
import com.jeeps.fichas_campo_client.model.Muestra;
import com.jeeps.fichas_campo_client.model.Pliegue;
import com.jeeps.fichas_campo_client.model.Ubicacion;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

public class ApiParserFacade {
    private Gson gson;

    public ApiParserFacade() {
        gson = new Gson();
    }

    public List<FichaCampo> parseFichasCampoList(String json) throws JSONException {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject embedded = jsonObject.getJSONObject("_embedded");
        JSONArray jsonFichasCampo = embedded.getJSONArray("fichasCampo");
        FichaCampo[] fichaCampos = gson.fromJson(jsonFichasCampo.toString(), FichaCampo[].class);
        return Arrays.asList(fichaCampos);
    }

    public FichaSubClassesHelper getFichaSubclasses(FichaCampo fichaCampo) {
        JsonObject selfLinks = fichaCampo.getSelfLinks();
        FichaSubClassesHelper fichaSubClassesHelper = new FichaSubClassesHelper();
        selfLinks.entrySet()
                .forEach(s -> {
                    switch (s.getKey()) {
                        case "self":
                            fichaSubClassesHelper.setSelfUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "muestra":
                            fichaSubClassesHelper.setMuestraUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "estructura-planar":
                            fichaSubClassesHelper.setEstructuraPlanarUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "ubicacion":
                            fichaSubClassesHelper.setUbicacionUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "estructura-lineal":
                            fichaSubClassesHelper.setEstructuraLinealUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "afloramiento":
                            fichaSubClassesHelper.setAfloramientoUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "pliegue":
                            fichaSubClassesHelper.setPliegueUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                    }
                });
        return fichaSubClassesHelper;
    }

    public Ubicacion parseUbicacion(String json) {
        return gson.fromJson(json, Ubicacion.class);
    }

    public Afloramiento parseAfloramiento(String json) {
        return gson.fromJson(json, Afloramiento.class);
    }

    public EstructuraLineal parseEstructuraLineal(String json) {
        return gson.fromJson(json, EstructuraLineal.class);
    }

    public EstructuraPlanar parseEstructuraPlanar(String json) {
        return gson.fromJson(json, EstructuraPlanar.class);
    }

    public Muestra parseMuestra(String json) {
        return gson.fromJson(json, Muestra.class);
    }

    public Pliegue parsePliegue(String json) {
        return gson.fromJson(json, Pliegue.class);
    }

    public String getJsonFromFichaCampo(FichaCampo fichaCampo) {
        String links = fichaCampo.getSubclassesLinks();
        fichaCampo.setSubclassesLinks(null);
        String preLinks =  gson.toJson(fichaCampo);
        return preLinks.replace("}", String.format(",\n%s\n}", links));
    }

    public String getJsonFromUbicacion(Ubicacion ubicacion) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return String.format("{" +
                        "\"canton\": \"%s\"," +
                        "\"escala\": \"%s\"," +
                        "\"fecha\": \"%s\"," +
                        "\"provincia\": \"%s\"," +
                        "\"sector\": \"%s\"," +
                        "\"foto\": \"%s\"" +
                "}", ubicacion.getCanton(), ubicacion.getEscala(), dateFormat.format(ubicacion.getFecha()),
                    ubicacion.getProvincia(), ubicacion.getSector(), ubicacion.getFoto());
    }

    public String getJsonFromMuestra(Muestra muestra) {
        return gson.toJson(muestra);
    }

    public String getJsonFromAfloramiento(Afloramiento afloramiento) {
        return gson.toJson(afloramiento);
    }

    public String getJsonFromEtructuraPlanar(EstructuraPlanar estructuraPlanar) {
        return gson.toJson(estructuraPlanar);
    }

    public String getJsonFromEstructuraLineal(EstructuraLineal estructuraLineal) {
        return gson.toJson(estructuraLineal);
    }

    public String getJsonFromPliegue(Pliegue pliegue) {
        return gson.toJson(pliegue);
    }
}
