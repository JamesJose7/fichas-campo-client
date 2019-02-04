package com.jeeps.fichas_campo_client.ports;

import com.jeeps.fichas_campo_client.model.Afloramiento;

public interface AfloramientoDaoPort {
    void requestAfloramiento(String url);
    void saveAfloramiento(Afloramiento afloramiento);
}
