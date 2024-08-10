package com.example.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SqliteActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private EditText nameEditText;
    private EditText ageEditText;
    private TextView dataTextView;
    private Button insertButton;
    private Button readButton;
    private Button updateButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sqlite);

        dbHelper = new DatabaseHelper(this);

        nameEditText = findViewById(R.id.nameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        dataTextView = findViewById(R.id.dataTextView);
        insertButton = findViewById(R.id.insertButton);
        readButton = findViewById(R.id.readButton);
        updateButton = findViewById(R.id.updateButton);
        deleteButton = findViewById(R.id.deleteButton);

        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                dbHelper.insertData(name, age);
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = dbHelper.getData();
                StringBuilder data = new StringBuilder();
                if (cursor.moveToFirst()) {
                    do {
                        int id = cursor.getInt(cursor.getColumnIndex("id"));
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        int age = cursor.getInt(cursor.getColumnIndex("age"));
                        data.append("ID: ").append(id)
                                .append(", Name: ").append(name)
                                .append(", Age: ").append(age)
                                .append("\n");
                    } while (cursor.moveToNext());
                }
                cursor.close();
                dataTextView.setText(data.toString());
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming ID is 1 for update
                int id = 1;
                String name = nameEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                dbHelper.updateData(id, name, age);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Assuming ID is 1 for delete
                int id = 1;
                dbHelper.deleteData(id);
            }
        });

    }
}