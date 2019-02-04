package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.Pliegue;

public interface PliegueDaoPort {
    void requestPliegue(String url);
    void savePliegue(Pliegue pliegue);
}
