package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.EstructuraLineal;

public interface EstructuraLinealDaoPort {
    void requestEstructuraLineal(String url);
    void saveEstructuraLineal(EstructuraLineal estructuraLineal);
}
