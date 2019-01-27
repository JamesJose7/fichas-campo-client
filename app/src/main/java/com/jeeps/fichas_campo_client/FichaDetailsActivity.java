package com.jeeps.fichas_campo_client;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.jeeps.fichas_campo_client.adapters.FichaCampoRecyclerViewAdapter;
import com.jeeps.fichas_campo_client.model.FichaSubClassesHelper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class FichaDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha_detailes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        FichaSubClassesHelper fichaSubClassesHelper =
                (FichaSubClassesHelper) bundle.getSerializable(FichaCampoRecyclerViewAdapter.SERIALIZED_FICHA);

        System.out.println(fichaSubClassesHelper.getSelfUrl());
        System.out.println(fichaSubClassesHelper.getAfloramientoUrl());
    }

}
