package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.EstructuraLineal;
import com.jeeps.fichas_campo_client.ports.EstructuraLinealDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiEstructuraLinealAdapter implements EstructuraLinealDaoPort,
        HttpService.HttpServiceListener {

    private ApiEstructuraLinealListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiEstructuraLinealListener {
        void estructuraLinealReady(EstructuraLineal estructuraLineal);
    }

    public ApiEstructuraLinealAdapter(ApiEstructuraLinealListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestEstructuraLineal(String url) {
        try {
            httpService.sendRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        EstructuraLineal estructuraLineal = apiParserFacade.parseEstructuraLineal(json);
        listener.estructuraLinealReady(estructuraLineal);
    }

    @Override
    public void onFailure() {

    }
}
