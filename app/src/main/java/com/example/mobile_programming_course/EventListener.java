package com.example.mobile_programming_course;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
public class EventListener extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_listener);

        // OnClickListener
        Button myButton = findViewById(R.id.my_button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click
                new AlertDialog.Builder(EventListener.this)
                        .setTitle("Clicked")
                        .setMessage("Button Clicked!")
                        .setPositiveButton("OK", null)
                        .show();
            }
        });

        // OnTouchListener
        View myView = findViewById(R.id.my_view);
        myView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // Handle touch event
                Toast.makeText(EventListener.this, "On Touch Listener", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(EventListener.this, FileUpload.class);
                startActivity(i);
                return true;

            }
        });

        // OnLongClickListener
        Button myLongClickButton = findViewById(R.id.my_long_click_button);
        myLongClickButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                // Handle long click
                new AlertDialog.Builder(EventListener.this)
                        .setTitle("Long Clicked")
                        .setMessage("Long Clicked Button!")
                        .setPositiveButton("OK", null)
                        .show();
                return true;
            }
        });

        // TextWatcher
        EditText myEditText = findViewById(R.id.my_edit_text);
        myEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Before text is changed
                Log.d(TAG, "Before text changed: " + s.toString());
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // Text is being changed
                Log.d(TAG, "Text is changing: " + s.toString());
                Toast.makeText(EventListener.this, "Text is changing: " + s.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // After text is changed
                Log.d(TAG, "After text changed: " + s.toString());
            }
        });

        // OnFocusChangeListener
        myEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                // Handle focus change
            }
        });

        // OnCheckedChangeListener
        CheckBox myCheckBox = findViewById(R.id.my_check_box);
        myCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // Handle check state change
            }
        });

        // OnSeekBarChangeListener
        SeekBar mySeekBar = findViewById(R.id.my_seek_bar);
        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Handle progress change
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Handle start of touch
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Handle stop of touch
            }
        });

        // OnDragListener
        View myDragView = findViewById(R.id.my_drag_view);
        myDragView.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View v, DragEvent event) {
                // Handle drag event
                return true;
            }
        });
    }

}