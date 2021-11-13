package com.julia.topic5_dialog;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity  extends FragmentActivity
        implements DialogoAlerta1.NoticeDialogListener {

    private TextView vista2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vista2 = (TextView) findViewById(R.id.cuadroTexto);
    }

    public void verDialog(View view) {
        // Create an instance of the dialog fragment and show it
        //DialogFragment dialog = new FireMissilesDialogFragment();
        //dialog.show(getSupportFragmentManager(), "NoticeDialogFragment");
        DialogFragment dialog = new DialogoAlerta1();
        dialog.show(getSupportFragmentManager(), DialogoAlerta1.TAG);
    }

    @Override
    public void onClick(DialogFragment dialog) {
        vista2.setText(DialogoAlerta1.seleccion);
    }

}