package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        Button showDialogButton = findViewById(R.id.show_dialog_button);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        // Create an AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set dialog title and message
        builder.setTitle("Dialog Title")
                .setMessage("This is a simple dialog message.")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Handle OK button click
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // Handle Cancel button click
                });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();

//        //  set a custom layout
//        LayoutInflater inflater = getLayoutInflater();
//        View dialogView = inflater.inflate(R.layout.dialog_custom, null);
//        builder.setView(dialogView);
//
//        // Create and show the dialog
//        AlertDialog dialog = builder.create();
//        dialog.show();
    }
}