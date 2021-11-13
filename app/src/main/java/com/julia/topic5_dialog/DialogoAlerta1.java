package com.julia.topic5_dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;


public class DialogoAlerta1 extends DialogFragment {
    public static String TAG = "DialogoAlerta1";
    public static String seleccion;

    public interface NoticeDialogListener {
        public void onClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    DialogoAlerta1.NoticeDialogListener listener;

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            listener = (DialogoAlerta1.NoticeDialogListener) context;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_color)
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // The 'which' argument contains the index position of the selected item
                        Resources res = getResources();
                        String[] colores = res.getStringArray(R.array.colors_array);
                        seleccion = colores[which];
                        listener.onClick(DialogoAlerta1.this);
                    }
                });
        return builder.create();
    }

}
