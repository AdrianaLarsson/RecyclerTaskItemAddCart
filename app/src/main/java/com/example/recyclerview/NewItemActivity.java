package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewItemActivity extends DialogFragment {

    ItemActivity mItemActivity = new ItemActivity();

    //creates a dialog so the user can write title an description
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        LayoutInflater inflater =
                getActivity().getLayoutInflater();

        View dialogView =
                inflater.inflate(R.layout.new_item, null);


        final EditText editTitle = (EditText) dialogView.findViewById(R.id.editTextTitle);
        final EditText editDescription = (EditText) dialogView.findViewById(R.id.editTextDescription);
        final TextView countItem = (TextView) dialogView.findViewById(R.id.badge_notification_1);


        Button buttonOK = (Button) dialogView.findViewById(R.id.buttonOK);
        builder.setView(dialogView).setMessage("Add a new note");



        // handle the cancel button
        buttonOK.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Quit the dialog
                dismiss();
            }
        });


        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new note
                ItemActivity itemActivity = new ItemActivity();


                itemActivity.setTitle(editTitle.
                        getText().toString());

                itemActivity.setDescription(editDescription.
                        getText().toString());




                MainActivity callingActivity = (
                        MainActivity) getActivity();


                // Pass newItem back to MainActivity
                callingActivity.newItem(itemActivity);

                // quits the dialog
                dismiss();

            }
        });

        return builder.create();

    }


    public void createNewNote(ItemActivity itemActivity){
        mItemActivity = itemActivity;
    }
}


