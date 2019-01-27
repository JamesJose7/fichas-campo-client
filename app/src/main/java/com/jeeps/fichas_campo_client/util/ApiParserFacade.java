package com.jeeps.fichas_campo_client.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.FichaSubClassesHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
                        case "estructura-linear":
                            fichaSubClassesHelper.setEstructuraLinealUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "afloramiento":
                            fichaSubClassesHelper.setAfloramientoUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                        case "pliegue":
                            fichaSubClassesHelper.setAfloramientoUrl(s.getValue().getAsJsonObject().get("href").getAsString());
                            break;
                    }
                });
        return fichaSubClassesHelper;
    }
}
