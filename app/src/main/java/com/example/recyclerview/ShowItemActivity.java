package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowItemActivity extends DialogFragment {

    private ItemActivity mItemActivity;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        LayoutInflater inflater =
                getActivity().getLayoutInflater();

        View dialogView =
                inflater.inflate(R.layout.show_item, null);

        TextView textViewTitle =
                (TextView) dialogView.findViewById(R.id.editTextTitle);

        TextView textViewDescription =
                (TextView) dialogView.findViewById(R.id.editTextDescription);

        textViewTitle.setText(mItemActivity.getTitle());
        textViewDescription.setText(mItemActivity.getDescription());

        Button btnOK = (Button) dialogView.findViewById(R.id.buttonOK);

        builder.setView(dialogView).setMessage("Your Note");

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return builder.create();




    }
    public void sendNoteSelected(ItemActivity itemSelected) {
        mItemActivity = itemSelected;



    }

}
