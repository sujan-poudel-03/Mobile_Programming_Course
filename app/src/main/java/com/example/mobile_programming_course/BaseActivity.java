package com.example.mobile_programming_course;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    protected void setupToolbar(){
        Toolbar toolbar = findViewById(R.id.to)
    }
}
