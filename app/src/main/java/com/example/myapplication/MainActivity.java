package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listView = (Button) findViewById(R.id.btn1);
        Button gridView = findViewById(R.id.btn2);
        Button recyclerView = findViewById(R.id.btn3);

        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);

            }
        });

        FrameLayout viewFrameContainer = findViewById(R.id.view_frame_container);

        Button showDialogButton = findViewById(R.id.show_dialog_button);
        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });


        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment frag = new ListViewFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.view_frame_container, frag);
                fragmentTransaction.commit();

            }
        });

        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new GridViewFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment){
        // Create a  new fragment and transaction
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.view_frame_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_items, menu);

        return true;
    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.profile:
//                openProfile();
//                return true;
//            case R.id.logout:
//                logout();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private void openProfile() {
        // Code to open profile activity or fragment
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    private void logout() {
        // Code to log out the user
        // For example, clearing session data or navigating to the login screen
        Toast.makeText(this, "Logged out", Toast.LENGTH_SHORT).show();
        finish();
    }
    private void showDialog() {
        // Create an AlertDialog.Builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // Set dialog title and message
        builder.setTitle("Dialog Title")
                .setMessage("This is a simple dialog message.")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Close the entire application
                    System.exit(0);
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // Handle Cancel button click
                });

        // Create and show the dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    }