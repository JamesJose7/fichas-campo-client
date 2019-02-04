package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.EstructuraPlanar;

public interface EstructuraPlanarDaoPort {
    void requestEstructuraPlanar(String url);
    void saveEstructuraPlanar(EstructuraPlanar estructuraPlanar);
}
