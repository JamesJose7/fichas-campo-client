package com.jeeps.fichas_campo_client;

import android.os.Bundle;

import com.jeeps.fichas_campo_client.adapters.ApiFichaCampoAdapter;
import com.jeeps.fichas_campo_client.adapters.FichaCampoRecyclerViewAdapter;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.util.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FichasCampoActivity extends AppCompatActivity
    implements ApiFichaCampoAdapter.ApiFichaCampoListener {

    @BindView(R.id.fichas_campo_recycler_view) RecyclerView mFichaCampoRecyclerView;
    private FichaCampoRecyclerViewAdapter mFichaCampoRecyclerViewAdapter;

    private List<FichaCampo> mFichasCampo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas_campo);
        ButterKnife.bind(this);
        setTitle("Fichas de Campo");

        ApiFichaCampoAdapter apiFichaCampoAdapter = new ApiFichaCampoAdapter(this);
        try {
            apiFichaCampoAdapter.requestFichasCampo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Initialize recycler view
        mFichasCampo = new ArrayList<>();
        mFichaCampoRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        mFichaCampoRecyclerViewAdapter = new FichaCampoRecyclerViewAdapter(this, mFichasCampo);
        mFichaCampoRecyclerView.setAdapter(mFichaCampoRecyclerViewAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FichasCampoActivity.this);
        mFichaCampoRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void fichasCampoReady(List<FichaCampo> fichasCampo) {
        mFichaCampoRecyclerViewAdapter.setFichaCampos(fichasCampo);
        runOnUiThread(() -> mFichaCampoRecyclerViewAdapter.notifyDataSetChanged());
    }
}
