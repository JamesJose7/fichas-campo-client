package com.jeeps.fichas_campo_client.menu;

import android.content.Context;
import android.content.Intent;

import com.jeeps.fichas_campo_client.FichaFormActivity;
import com.jeeps.fichas_campo_client.dialogs.LoginDialog;
import com.jeeps.fichas_campo_client.model.User;

import androidx.fragment.app.FragmentManager;

public class AppMenu {
    private Context mContext;
    private FragmentManager mFragmentManager;

    public AppMenu(Context context, FragmentManager fragmentManager) {
        mContext = context;
        mFragmentManager = fragmentManager;
    }

    public void promptLogin() {
        LoginDialog dialog = new LoginDialog(mContext, User.getInstance());
        dialog.show(mFragmentManager, "TAG");
    }

    public void addFicha() {
        Intent intent = new Intent(mContext, FichaFormActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
