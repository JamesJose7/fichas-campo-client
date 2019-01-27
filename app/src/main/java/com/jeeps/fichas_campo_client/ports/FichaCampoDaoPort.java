package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.FichaCampo;

import java.util.List;

public interface FichaCampoDaoPort {
    List<FichaCampo> getFichasCampo();
}
