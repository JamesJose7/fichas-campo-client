package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.EstructuraLineal;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.ports.EstructuraLinealDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiEstructuraLinealAdapter implements EstructuraLinealDaoPort,
        HttpService.HttpServiceListener {

    private final String ESTRUCTURA_LINEAL_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/estructurasLineales";

    private ApiEstructuraLinealListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiEstructuraLinealListener {
        void estructuraLinealReady(EstructuraLineal estructuraLineal);
        void estructuraLinealSaved(String estructuraUrl);
    }

    public ApiEstructuraLinealAdapter(ApiEstructuraLinealListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestEstructuraLineal(String url) {
        try {
            httpService.sendAuthRequest(url, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEstructuraLineal(EstructuraLineal estructuraLineal) {
        try {
            String json = apiParserFacade.getJsonFromEstructuraLineal(estructuraLineal);
            httpService.postAuthRequest(ESTRUCTURA_LINEAL_URL, json, User.getInstance());
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

    @Override
    public void postResult(String json) {
        listener.estructuraLinealSaved(json);
    }
}
