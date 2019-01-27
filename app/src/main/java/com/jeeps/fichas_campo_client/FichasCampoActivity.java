package com.jeeps.fichas_campo_client;

import android.os.Bundle;

import com.jeeps.fichas_campo_client.adapters.ApiFichaCampoAdapter;
import com.jeeps.fichas_campo_client.model.FichaCampo;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.ButterKnife;

public class FichasCampoActivity extends AppCompatActivity
    implements ApiFichaCampoAdapter.ApiFichaCampoListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas_campo);
        ButterKnife.bind(this);

        ApiFichaCampoAdapter apiFichaCampoAdapter = new ApiFichaCampoAdapter(this);
        try {
            apiFichaCampoAdapter.requestFichasCampo();
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
