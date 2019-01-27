package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.ports.FichaCampoDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

import org.json.JSONException;

import java.util.List;

public class ApiFichaCampoAdapter implements FichaCampoDaoPort,
        HttpService.HttpServiceListener {
    private static final String FICHAS_CAMPO_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/fichasCampo?size=50";

    private ApiFichaCampoListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiFichaCampoListener {
        void fichasCampoReady(List<FichaCampo> fichasCampo);
    }

    public ApiFichaCampoAdapter(ApiFichaCampoListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestFichasCampo() {
        try {
            httpService.sendRequest(FICHAS_CAMPO_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        // Transform fichas de campo into object list
        try {
            List<FichaCampo> fichaCampoList = apiParserFacade.parseFichasCampoList(json);
            listener.fichasCampoReady(fichaCampoList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
