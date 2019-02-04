package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.EstructuraPlanar;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.ports.EstructuraPlanarDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiEstructuraPlanarAdapter implements EstructuraPlanarDaoPort,
        HttpService.HttpServiceListener {

    private final String ESTRUCTURA_PLANAR_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/estructuraPlanar";

    private ApiEstructuraPlanarListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiEstructuraPlanarListener {
        void estructuraPlanarReady(EstructuraPlanar estructuraPlanar);
        void estructuraPlanarSaved(String estructuraUrl);
    }

    public ApiEstructuraPlanarAdapter(ApiEstructuraPlanarListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestEstructuraPlanar(String url) {
        try {
            httpService.sendAuthRequest(url, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveEstructuraPlanar(EstructuraPlanar estructuraPlanar) {
        try {
            String json = apiParserFacade.getJsonFromEtructuraPlanar(estructuraPlanar);
            httpService.postAuthRequest(ESTRUCTURA_PLANAR_URL, json, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        EstructuraPlanar estructuraPlanar = apiParserFacade.parseEstructuraPlanar(json);
        listener.estructuraPlanarReady(estructuraPlanar);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void postResult(String json) {
        listener.estructuraPlanarSaved(json);
    }
}
