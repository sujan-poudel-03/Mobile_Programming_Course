package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {

    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String GET_URL = "https://jsonplaceholder.typicode.com/posts/1";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_volley);

        EditText titleEditText = findViewById(R.id.titleEditText);
        EditText bodyEditText = findViewById(R.id.bodyEditText);
        Button postBtn = findViewById(R.id.postBtn);
        Button getBtn = findViewById(R.id.getBtn);
        TextView getDataTextView = findViewById(R.id.getDataTextView);

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // POST Request
        postBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString();
                String body = bodyEditText.getText().toString();

                JSONObject jsonBody = new JSONObject();
                try {
                    jsonBody.put("title", title);
                    jsonBody.put("body", body);
                    jsonBody.put("userId", 1); // Example userId
                } catch (Exception e) {
                    e.printStackTrace();
                }

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.POST,
                        POST_URL,
                        jsonBody,
                        response -> {
                            Log.d("VolleyResponse POST", response.toString());
                            Toast.makeText(VolleyActivity.this, "Success", Toast.LENGTH_SHORT).show();
                        },
                        error -> Log.e("VolleyError", error.toString())
                );

                requestQueue.add(jsonObjectRequest);

            }
        });

        // Handle GET request and populate TextView
        getBtn.setOnClickListener(v -> {
            StringRequest stringRequest = new StringRequest(Request.Method.GET, GET_URL,
                    response -> {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String title = jsonObject.getString("title");
                            String body = jsonObject.getString("body");

                            String displayText = "Title: " + title + "\nBody: " + body;
                            getDataTextView.setText(displayText);

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    },
                    error -> Log.e("VolleyError", error.toString())
            );

            requestQueue.add(stringRequest);
        });

    }
}