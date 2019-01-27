package com.jeeps.fichas_campo_client.util;

import com.google.gson.Gson;
import com.jeeps.fichas_campo_client.model.FichaCampo;

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
}
