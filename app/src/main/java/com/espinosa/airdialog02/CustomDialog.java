package com.espinosa.airdialog02;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by 9720JAS-PC-LT on 10/5/2017.
 */

public class CustomDialog extends DialogFragment {

    LayoutInflater inflater;
    View view;
    EditText eUser, ePwd;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.login_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setView(view);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                eUser = view.findViewById(R.id.et_username);
                ePwd = view.findViewById(R.id.et_password);
                String user = eUser.getText().toString();
                String password = ePwd.getText().toString();
                String msg = "Username is " + user + ", Password is " + password;
                Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        Dialog dialog = builder.create();
        return dialog;

    }
}
