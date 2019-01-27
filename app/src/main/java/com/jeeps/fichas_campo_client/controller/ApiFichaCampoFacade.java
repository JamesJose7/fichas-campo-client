package com.jeeps.fichas_campo_client.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.service.HttpService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiFichaCampoFacade implements HttpService.HttpServiceListener {
    private static final String FICHAS_CAMPO_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/fichasCampo";

    private ApiFichaCampoListener listener;
    private HttpService httpService;
    private Gson gson;

    public interface ApiFichaCampoListener {
        void fichasCampoReady(List<FichaCampo> fichasCampo);
    }

    public ApiFichaCampoFacade(ApiFichaCampoListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        gson = new Gson();
    }

    public void requestFichasCampo() throws Exception {
        httpService.sendRequest(FICHAS_CAMPO_URL);
    }

    @Override
    public void onSuccess(String json) {
        // Transform fichas de campo into object list
        List<FichaCampo> fichaCampoList = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONObject embedded = jsonObject.getJSONObject("_embedded");
            JSONArray jsonFichasCampo = embedded.getJSONArray("fichasCampo");
            FichaCampo[] fichaCampos = gson.fromJson(jsonFichasCampo.toString(), FichaCampo[].class);
            fichaCampoList = Arrays.asList(fichaCampos);
            listener.fichasCampoReady(fichaCampoList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
