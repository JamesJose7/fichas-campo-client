package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.Ubicacion;

public interface UbicacionDaoPort {
    void requestUbicaciones();
    void requestUbicacion(String url);
    void saveUbicacion(Ubicacion ubicacion);
}
