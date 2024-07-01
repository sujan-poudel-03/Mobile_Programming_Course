package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    private EditText fullNameEditText;
    private EditText emailEditText;
    private Spinner coursesSpinner;
    private RadioGroup genderRadioGroup;
    private CheckBox hobbySingingCheckBox;
    private CheckBox hobbyPlayingCheckBox;
    private Button signUpButton;

    public SignUp() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Initialize UI components
        fullNameEditText = findViewById(R.id.full_name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        coursesSpinner = findViewById(R.id.spinner_courses);
        genderRadioGroup = findViewById(R.id.gender);
        hobbySingingCheckBox = findViewById(R.id.hobby_singing);
        hobbyPlayingCheckBox = findViewById(R.id.hobby_playing);
        signUpButton = findViewById(R.id.signup);

        // Set click listener for the sign-up button
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignUp();
            }
        });
    }

    private void handleSignUp() {
        String fullName = fullNameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String selectedCourse = coursesSpinner.getSelectedItem().toString();
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
        String selectedGender = selectedGenderRadioButton != null ? selectedGenderRadioButton.getText().toString() : "";
        boolean hobbySinging = hobbySingingCheckBox.isChecked();
        boolean hobbyPlaying = hobbyPlayingCheckBox.isChecked();

        // Display a simple message to the user
        String message = "Full Name: " + fullName + "\n" +
                "Email: " + email + "\n" +
                "Course: " + selectedCourse + "\n" +
                "Gender: " + selectedGender + "\n" +
                "Hobbies: " + (hobbySinging ? "Singing " : "") + (hobbyPlaying ? "Playing " : "");

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

}