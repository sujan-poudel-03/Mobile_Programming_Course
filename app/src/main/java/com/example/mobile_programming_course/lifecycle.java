package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class lifecycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
    }
    
    @Override
    protected void onStart(){
        super.onStart();
        Log.d("Lifecycle", "onStart called");
        startAnimation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Lifecycle", "onResume called");
        // The activity has become visible (it is now "resumed")
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Lifecycle", "onPause called");
        // Another activity is taking focus (this activity is about to be "paused")
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Lifecycle", "onStop called");
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Lifecycle", "onRestart called");
        // The activity is about to be restarted
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Lifecycle", "onDestroy called");
        // The activity is about to be destroyed
    }



    private void startAnimation() {
        // Find the view you want to animate
        View myView = findViewById(R.id.my_view);

        // Create an animation (e.g., a fade in animation)
        Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setDuration(1000); // Duration in milliseconds

        // Start the animation
        myView.startAnimation(fadeIn);
    }
    
}