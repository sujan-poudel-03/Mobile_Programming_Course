package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

public class EventListener extends AppCompatActivity {

    private ImageView imageView;
    private Button buttonClick;
    private EditText editText;
    private ScrollView scrollView;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_listener);

        imageView = findViewById(R.id.imageView);
        buttonClick = findViewById(R.id.buttonClick);
        editText = findViewById(R.id.editText);
        scrollView = findViewById(R.id.scrollView);

        // Image View Touch
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(EventListener.this, "Image View Touched", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                return false;
            }
        });

        // Button View Long Click
        buttonClick.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(EventListener.this, "Ready to download", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        // Button click listener
        buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventListener.this, "Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // EditText text change listener
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Code to execute before text is changed
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Code to execute when text is changing
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Code to execute after text has changed
                Toast.makeText(EventListener.this, "Text Changed: " + s.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        // View touch listener
        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Toast.makeText(EventListener.this, "View Touched", Toast.LENGTH_SHORT).show();
                        return true;
                }
                return false;
            }
        });

        // View long click listener
        editText.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(EventListener.this, "Long Click Detected", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        // View focus change listener
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Toast.makeText(EventListener.this, "EditText Focused", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EventListener.this, "EditText Lost Focus", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // ScrollView scroll listener
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            private float y1, y2;

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        y1 = event.getY();
                        return false;
                    case MotionEvent.ACTION_UP:
                        y2 = event.getY();
                        if (y1 < y2) {
                            Toast.makeText(EventListener.this, "Scrolling Down", Toast.LENGTH_SHORT).show();
                        } else if (y1 > y2) {
                            Toast.makeText(EventListener.this, "Scrolling Up", Toast.LENGTH_SHORT).show();
                        }
                        return false;
                }
                return false;
            }
        });

        // Gesture detector for handling scrolls
        gestureDetector = new GestureDetector(this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                if (distanceY > 0) {
                    Toast.makeText(EventListener.this, "Scrolling Up", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EventListener.this, "Scrolling Down", Toast.LENGTH_SHORT).show();
                }
                return super.onScroll(e1, e2, distanceX, distanceY);
            }
        });
    }
}