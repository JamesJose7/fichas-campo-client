package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.FichaCampo;

public interface FichaCampoDaoPort {
    void requestFichasCampo();
    void saveFichaCampo(FichaCampo fichaCampo);
}
