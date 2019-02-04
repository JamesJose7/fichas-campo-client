package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.Ubicacion;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.ports.UbicacionDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

public class ApiUbicacionAdapter implements UbicacionDaoPort,
        HttpService.HttpServiceListener {

    private static final String UBICACION_URL = "https://fichas-geologicas-api.herokuapp.com/api/v1/ubicaciones";
    private ApiUbicacionListener listener;
    private HttpService httpService;
    private ApiParserFacade apiParserFacade;

    public interface ApiUbicacionListener {
        void ubicacionReady(Ubicacion ubicacion);
        void ubicacionSaved(String ubicacionUrl);
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
            httpService.sendAuthRequest(url, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveUbicacion(Ubicacion ubicacion) {
        try {
            String json = apiParserFacade.getJsonFromUbicacion(ubicacion);
            httpService.postAuthRequest(UBICACION_URL, json, User.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSuccess(String json) {
        Ubicacion ubicacion = apiParserFacade.parseUbicacion(json);
        listener.ubicacionReady(ubicacion);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void postResult(String json) {
        listener.ubicacionSaved(json);
    }
}
