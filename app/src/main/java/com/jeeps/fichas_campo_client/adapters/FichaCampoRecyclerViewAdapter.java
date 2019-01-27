package com.jeeps.fichas_campo_client.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jeeps.fichas_campo_client.FichaDetailsActivity;
import com.jeeps.fichas_campo_client.R;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.FichaSubClassesHelper;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FichaCampoRecyclerViewAdapter
        extends RecyclerView.Adapter<FichaCampoRecyclerViewAdapter.FichaCampoViewHolder> {

    public static final String SERIALIZED_FICHA = "SERIALIZED_FICHA";
    private Context mContext;
    private List<FichaCampo> mFichaCampos;

    public FichaCampoRecyclerViewAdapter(Context context, List<FichaCampo> fichaCampos) {
        mContext = context;
        mFichaCampos = fichaCampos;
    }

    @NonNull
    @Override
    public FichaCampoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ficha_campo_list_item, parent, false);
        return new FichaCampoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FichaCampoViewHolder holder, int position) {
        holder.bindFichaCampo(mFichaCampos, position);
    }

    @Override
    public int getItemCount() {
        return mFichaCampos.size();
    }

    public List<FichaCampo> getFichaCampos() {
        return mFichaCampos;
    }

    public void setFichaCampos(List<FichaCampo> fichaCampos) {
        mFichaCampos = fichaCampos;
    }

    class FichaCampoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.ficha_item_layout) LinearLayout mLinearLayout;
        @BindView(R.id.datum_text) TextView mDatumText;
        @BindView(R.id.escala_text) TextView mEscalaText;
        @BindView(R.id.proyecto_text) TextView mProyectoText;
        @BindView(R.id.descrita_por_text) TextView mDescritaPorText;

        FichaCampoViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindFichaCampo(List<FichaCampo> fichaCampos, int position) {
            FichaCampo fichaCampo = fichaCampos.get(position);
            mDatumText.setText(fichaCampo.getDatum());
            mEscalaText.setText(fichaCampo.getEscala());
            mProyectoText.setText(fichaCampo.getProyecto());
            mDescritaPorText.setText(fichaCampo.getDescritaPor());

            // Set on click listener for layout
            mLinearLayout.setOnClickListener(v -> {
                ApiParserFacade apiParserFacade = new ApiParserFacade();
                FichaSubClassesHelper fichaSubClassesHelper =
                        apiParserFacade.getFichaSubclasses(fichaCampos.get(position));
                // Pass the object to the details ficha activity
                Bundle bundle = new Bundle();
                bundle.putSerializable(SERIALIZED_FICHA, fichaSubClassesHelper);
                Intent intent = new Intent(mContext, FichaDetailsActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            });
        }
    }
}
