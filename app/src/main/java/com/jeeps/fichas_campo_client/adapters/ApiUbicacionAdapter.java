package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Ubicacion;
import com.jeeps.fichas_campo_client.ports.UbicacionDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiUbicacionAdapter implements UbicacionDaoPort,
        HttpService.HttpServiceListener {

    private ApiUbicacionListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiUbicacionListener {
        void ubicacionReady(Ubicacion ubicacion);
    }

    public ApiUbicacionAdapter(ApiUbicacionListener listener) {
        this.listener = listener;
        httpService = new HttpService(this);
        apiParserFacade = new ApiParserFacade();
    }

    @Override
    public void requestUbicaciones() {

    }

    @Override
    public void requestUbicacion(String url) {
        try {
            httpService.sendRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        Ubicacion ubicacion = apiParserFacade.parseUbicacion(json);
        listener.ubicacionReady(ubicacion);
    }
}
