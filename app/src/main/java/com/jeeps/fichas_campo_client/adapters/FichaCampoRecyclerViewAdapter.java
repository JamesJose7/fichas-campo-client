package com.jeeps.fichas_campo_client.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.jeeps.fichas_campo_client.FichaDetailsActivity;
import com.jeeps.fichas_campo_client.R;
import com.jeeps.fichas_campo_client.model.FichaCampo;
import com.jeeps.fichas_campo_client.model.FichaSubClassesHelper;
import com.jeeps.fichas_campo_client.model.User;
import com.jeeps.fichas_campo_client.service.HttpService;
import com.jeeps.fichas_campo_client.util.ApiParserFacade;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FichaCampoRecyclerViewAdapter
        extends RecyclerView.Adapter<FichaCampoRecyclerViewAdapter.FichaCampoViewHolder> {

    public static final String SERIALIZED_FICHA = "SERIALIZED_FICHA";
    public static final String SERIALIZED_FICHA_SUB = "SERIALIZED_FICHA_SUB";
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
                FichaCampo sentFicha = fichaCampos.get(position);
                // null JsonObject since it cannot be serialized
                sentFicha.setSelfLinks(null);
                bundle.putSerializable(SERIALIZED_FICHA, sentFicha);
                bundle.putSerializable(SERIALIZED_FICHA_SUB, fichaSubClassesHelper);
                Intent intent = new Intent(mContext, FichaDetailsActivity.class);
                intent.putExtras(bundle);
                mContext.startActivity(intent);
            });

            mLinearLayout.setOnLongClickListener(v -> {
                String selfUrl = mFichaCampos.get(position).getSelfLinks().get("self").getAsJsonObject().get("href").getAsString();
                HttpService httpService = new HttpService(new HttpService.HttpServiceListener() {
                    @Override
                    public void onSuccess(String json) {
                        ((Activity) mContext).runOnUiThread(() -> {
                            removeAt(position);
                            Snackbar.make(v, "Ficha eliminada", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        });
                    }

                    @Override
                    public void onFailure() {}

                    @Override
                    public void postResult(String json) {}
                });
                try {
                    httpService.sendDeleteRequest(selfUrl, User.getInstance());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            });
        }
    }

    public void removeAt(int position) {
        List<FichaCampo> listCopy = new ArrayList<>(mFichaCampos);
        listCopy.remove(position);
        mFichaCampos = new ArrayList<>(listCopy);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, mFichaCampos.size());
    }
}
