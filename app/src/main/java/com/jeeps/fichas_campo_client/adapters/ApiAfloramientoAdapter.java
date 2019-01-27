package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Afloramiento;
import com.jeeps.fichas_campo_client.ports.AfloramientoDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiAfloramientoAdapter implements AfloramientoDaoPort,
        HttpService.HttpServiceListener {

    private ApiAfloramientoListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiAfloramientoListener {
        void afloramientoReady(Afloramiento afloramiento);
    }

    public ApiAfloramientoAdapter(ApiAfloramientoListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestAfloramiento(String url) {
        try {
            httpService.sendRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        Afloramiento afloramiento = apiParserFacade.parseAfloramiento(json);
        listener.afloramientoReady(afloramiento);
    }
}