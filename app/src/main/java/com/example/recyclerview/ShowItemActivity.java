package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowItemActivity extends DialogFragment {

    private ItemActivity mItemActivity;
    private RecyclerView recyclerView;
    private int value = 0;
    private ItemAdapterActivity mAdapter;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        LayoutInflater inflater =
                getActivity().getLayoutInflater();

        View dialogView =
                inflater.inflate(R.layout.show_item, null);

        TextView textViewTitle =
                (TextView) dialogView.findViewById(R.id.textViewTitle);

        TextView textViewDescription =
                (TextView) dialogView.findViewById(R.id.textViewDescription);

        textViewTitle.setText(mItemActivity.getTitle());
        textViewDescription.setText(mItemActivity.getDescription());


        final TextView textViewCount = (TextView) dialogView.findViewById(R.id.badge_notification_1);


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
