package com.example.test.ui.main;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.R;
import android.view.Gravity;

public class HelpDialog extends DialogFragment {

    private MainViewModel mViewModel;
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle(getResources().getString(R.string.help_title));
            builder.setMessage(getResources().getString(R.string.help_text));
            builder.setPositiveButton(getResources().getString(R.string.help_y), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    String Str = mViewModel.getHelp();
                    Toast toast = Toast.makeText(getActivity(),Str.substring(0,1)+"...", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                }
            });
            builder.setNegativeButton(getResources().getString(R.string.help_n), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                }
            });
            builder.setCancelable(true);

            return builder.create();
        }
    }

