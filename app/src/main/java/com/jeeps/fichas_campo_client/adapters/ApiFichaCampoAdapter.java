package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.ports.FichaCampoDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ApiFichaCampoAdapter implements FichaCampoDaoPort,
        HttpService.HttpServiceListener {
    private static final String FICHAS_CAMPO_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/fichasCampo";

    private ApiFichaCampoListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;
    private User mUser;

    public interface ApiFichaCampoListener {
        void fichasCampoReady(List<FichaCampo> fichasCampo);
    }

    public ApiFichaCampoAdapter(ApiFichaCampoListener listener, User user) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
        mUser = user;
    }

    @Override
    public void requestFichasCampo() {
        try {
            httpService.sendAuthRequest(FICHAS_CAMPO_URL, mUser);
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

    @Override
    public void onFailure() {
        listener.fichasCampoReady(new ArrayList<>());
    }

    public void setUser(User user) {
        mUser = user;
    }
}
