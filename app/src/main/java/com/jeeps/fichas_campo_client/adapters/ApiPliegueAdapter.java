package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Pliegue;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.ports.PliegueDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiPliegueAdapter implements PliegueDaoPort,
        HttpService.HttpServiceListener {

    private final String PLIEGUES_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/pliegues";

    private ApiPliegueListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiPliegueListener {
        void pliegueReady(Pliegue pliegue);
        void pliegueSaved(String pliegueUrl);
    }

    public ApiPliegueAdapter(ApiPliegueListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestPliegue(String url) {
        try {
            httpService.sendAuthRequest(url, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePliegue(Pliegue pliegue) {
        try {
            String json = apiParserFacade.getJsonFromPliegue(pliegue);
            httpService.postAuthRequest(PLIEGUES_URL, json, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        Pliegue pliegue = apiParserFacade.parsePliegue(json);
        listener.pliegueReady(pliegue);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void postResult(String json) {
        listener.pliegueSaved(json);
    }
}
