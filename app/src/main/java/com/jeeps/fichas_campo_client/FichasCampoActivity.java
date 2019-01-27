package com.jeeps.fichas_campo_client;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.jeeps.fichas_campo_client.adapters.ApiFichaCampoAdapter;
import com.jeeps.fichas_campo_client.adapters.FichaCampoRecyclerViewAdapter;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.util.SimpleDividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FichasCampoActivity extends AppCompatActivity
    implements ApiFichaCampoAdapter.ApiFichaCampoListener {

    @BindView(R.id.ficha_campo_refresher)SwipeRefreshLayout mSwipeRefreshLayout;

    @BindView(R.id.fichas_campo_recycler_view) RecyclerView mFichaCampoRecyclerView;
    private FichaCampoRecyclerViewAdapter mFichaCampoRecyclerViewAdapter;

    private List<FichaCampo> mFichasCampo;
    private ApiFichaCampoAdapter mApiFichaCampoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fichas_campo);
        ButterKnife.bind(this);
        setTitle("Fichas de Campo");

        mApiFichaCampoAdapter = new ApiFichaCampoAdapter(this);
        try {
            mApiFichaCampoAdapter.requestFichasCampo();
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

        // Set refresh on swipe listener
        mSwipeRefreshLayout.setOnRefreshListener(() -> {
            try {
                mApiFichaCampoAdapter.requestFichasCampo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void fichasCampoReady(List<FichaCampo> fichasCampo) {
        mFichaCampoRecyclerViewAdapter.setFichaCampos(fichasCampo);
        runOnUiThread(() -> {
            mFichaCampoRecyclerViewAdapter.notifyDataSetChanged();
            mSwipeRefreshLayout.setRefreshing(false);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ficha_campo_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_refresh:
                mSwipeRefreshLayout.setRefreshing(true);
                try {
                    mApiFichaCampoAdapter.requestFichasCampo();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
