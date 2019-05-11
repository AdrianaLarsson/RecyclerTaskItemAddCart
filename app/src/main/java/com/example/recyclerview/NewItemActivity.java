package com.example.recyclerview;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewItemActivity extends DialogFragment {

    ItemActivity mItemActivity = new ItemActivity();

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

        Button buttonOK = (Button) dialogView.findViewById(R.id.buttonOK);
        builder.setView(dialogView).setMessage("Add a new note");



        // Handle the cancel button
        buttonOK.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a new note
                ItemActivity itemActivity = new ItemActivity();

                // Set its variables to match the
                // user's entries on the form
                itemActivity.setTitle(editTitle.
                        getText().toString());

                itemActivity.setDescription(editDescription.
                        getText().toString());

                MainActivity callingActivity = (
                        MainActivity) getActivity();

                // Pass newNote back to MainActivity
                callingActivity.createNewNote(itemActivity);

                // Quit the dialog
                dismiss();

            }
        });

        return builder.create();

    }


    public void createNewNote(ItemActivity itemActivity){
        // Temporary code
        mItemActivity = itemActivity;
    }
}


