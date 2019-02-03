package com.jeeps.fichas_campo_client.dialogs;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.jeeps.fichas_campo_client.R;
import com.jeeps.fichas_campo_client.model.User;

import androidx.fragment.app.DialogFragment;

import static android.content.Context.INPUT_METHOD_SERVICE;

@SuppressLint("ValidFragment")
public class LoginDialog extends DialogFragment {

    private Context mContext;
    private User mUser;

    private EditText mUsernameField;
    private EditText mPasswordField;

    public LoginDialog(Context context, User user) {
        super();
        mContext = context;
        mUser = user;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Get the layout inflater
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        builder.setTitle("Login");

        //Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout;
        View layout = layoutInflater.inflate(R.layout.login_dialog, null);

        // Edit text
        mUsernameField = layout.findViewById(R.id.username);
        mUsernameField.requestFocus();
        mUsernameField.setText(mUser.getUsername());
        mPasswordField = layout.findViewById(R.id.password);

        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        builder.setView(layout)
                //Add buttons
                .setPositiveButton("Ingresar", (dialog, which) -> {
                    String username = mUsernameField.getText().toString();
                    String password = mPasswordField.getText().toString();
                    User user = User.getInstance();
                    user.setUsername(username);
                    user.setPassword(password);
                    //Hide keyboard
                    hideKeyboard();
                })
                .setNegativeButton("Cancelar", (dialog, id) -> {
                    hideKeyboard();
                    LoginDialog.this.getDialog().cancel();
                });

        return builder.create();
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) mContext.getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mUsernameField.getWindowToken(), 0);
    }
}
