package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText emailText = findViewById(R.id.email_input);
        EditText passwordText = findViewById(R.id.password_input);
        Button loginBtn = findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.print("Button Pressed");
                Toast.makeText(MainActivity.this, "Login Pressed", Toast.LENGTH_SHORT).show();
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();
                if (email.equals("admin") && password.equals("admin")) {
                    System.out.println("Email : "+ email);
                    System.out.println("Password : " + password);
                    Toast.makeText(MainActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        Intent newPage = new Intent(MainActivity.this, Syllabus.class);
                        startActivity(newPage);
                        newPage.putExtra("username", email);
                } else {
                    Toast.makeText(MainActivity.this, "Login Failed!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}