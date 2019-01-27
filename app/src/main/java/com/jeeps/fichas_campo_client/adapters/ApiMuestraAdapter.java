package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Muestra;
import com.jeeps.fichas_campo_client.ports.MuestraDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiMuestraAdapter implements MuestraDaoPort,
        HttpService.HttpServiceListener {

    private ApiMuestraListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiMuestraListener {
        void muestraReady(Muestra muestra);
    }

    public ApiMuestraAdapter(ApiMuestraListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestMuestra(String url) {
        try {
            httpService.sendRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        Muestra muestra = apiParserFacade.parseMuestra(json);
        listener.muestraReady(muestra);
    }
}
