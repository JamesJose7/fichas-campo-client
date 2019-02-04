package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.Muestra;

public interface MuestraDaoPort {
    void requestMuestra(String url);
    void saveMuestra(Muestra muestra);
}
