package com.jeeps.fichas_campo_client.adapters;

import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.ports.FichaCampoDaoPort;
import com.jeeps.fichas_campo_client.service.HttpService;

import java.util.List;

public class ApiFichaCampoDaoAdapter implements FichaCampoDaoPort {
    @Override
    public List<FichaCampo> getFichasCampo() {
        return null;
    }
}
