package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Pliegue;
import com.jeeps.fichas_campo_client.ports.PliegueDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiPliegueAdapter implements PliegueDaoPort,
        HttpService.HttpServiceListener {

    private ApiPliegueListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiPliegueListener {
        void pliegueReady(Pliegue pliegue);
    }

    public ApiPliegueAdapter(ApiPliegueListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestPliegue(String url) {
        try {
            httpService.sendRequest(url);
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
}
