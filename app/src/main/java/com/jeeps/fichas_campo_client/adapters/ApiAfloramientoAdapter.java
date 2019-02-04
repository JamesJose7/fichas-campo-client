package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Afloramiento;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.ports.AfloramientoDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiAfloramientoAdapter implements AfloramientoDaoPort,
        HttpService.HttpServiceListener {

    private final String AFLORAMIENTO_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/afloramientos";

    private ApiAfloramientoListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiAfloramientoListener {
        void afloramientoReady(Afloramiento afloramiento);
        void afloramientoSaved(String afloramientoUrl);
    }

    public ApiAfloramientoAdapter(ApiAfloramientoListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestAfloramiento(String url) {
        try {
            httpService.sendAuthRequest(url, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAfloramiento(Afloramiento afloramiento) {
        try {
            String json = apiParserFacade.getJsonFromAfloramiento(afloramiento);
            httpService.postAuthRequest(AFLORAMIENTO_URL, json, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        Afloramiento afloramiento = apiParserFacade.parseAfloramiento(json);
        listener.afloramientoReady(afloramiento);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void postResult(String json) {
        listener.afloramientoSaved(json);
    }
}
