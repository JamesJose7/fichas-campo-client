package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Muestra;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.ports.MuestraDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiMuestraAdapter implements MuestraDaoPort,
        HttpService.HttpServiceListener {

    private final String MUESTRA_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/muestras";

    private ApiMuestraListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiMuestraListener {
        void muestraReady(Muestra muestra);
        void muestraSaved(String muestraUrl);
    }

    public ApiMuestraAdapter(ApiMuestraListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestMuestra(String url) {
        try {
            httpService.sendAuthRequest(url, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveMuestra(Muestra muestra) {
        try {
            String json = apiParserFacade.getJsonFromMuestra(muestra);
            httpService.postAuthRequest(MUESTRA_URL, json, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        Muestra muestra = apiParserFacade.parseMuestra(json);
        listener.muestraReady(muestra);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void postResult(String json) {
        listener.muestraSaved(json);
    }
}
