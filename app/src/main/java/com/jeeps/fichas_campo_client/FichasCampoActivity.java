package com.jeeps.fichas_campo_client;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jeeps.fichas_campo_client.controller.ApiFichaCampoFacade;
import com.jeeps.fichas_campo_client.model.FichaCampo;

import java.util.List;

public class FichasCampoActivity extends AppCompatActivity
    implements ApiFichaCampoFacade.ApiFichaCampoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas_campo);

        ApiFichaCampoFacade apiFichaCampoFacade = new ApiFichaCampoFacade(this);
        try {
            apiFichaCampoFacade.requestFichasCampo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void fichasCampoReady(List<FichaCampo> fichasCampo) {
        fichasCampo.forEach(ficha -> System.out.printf("%s\n%s\n%s\n\n",
                ficha.getDatum(), ficha.getEscala(), ficha.getProyecto()));
    }
}
