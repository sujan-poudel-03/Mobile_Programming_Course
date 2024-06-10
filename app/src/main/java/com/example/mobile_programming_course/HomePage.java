package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Intent getEmail = getIntent();
        getEmail.getStringExtra("username");
        System.out.print("Get Email : " + getEmail);
    }
}