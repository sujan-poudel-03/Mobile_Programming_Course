package com.example.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class VolleyActivity extends AppCompatActivity {

    private static final String POST_URL = "https://jsonplaceholder.typicode.com/posts";
    private static final String GET_URL = "https://jsonplaceholder.typicode.com/posts/1";

    private EditText titleEditText;
    private EditText bodyEditText;
    private Button sendButton;
    private Button getButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_volley);

        titleEditText = findViewById(R.id.titleEditText);
        bodyEditText = findViewById(R.id.bodyEditText);
        sendButton = findViewById(R.id.sendButton);
        getButton = findViewById(R.id.getButton);

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        // Handle POST request
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("title", "this is a title");
            jsonBody.put("body", "this is a body");
            jsonBody.put("userId", 1); // Example userId
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.POST,
                POST_URL,
                jsonBody,
                response -> Log.d("VolleyResponse POST", response.toString()),
                error -> Log.e("VolleyError", error.toString())
        );

        requestQueue.add(jsonObjectRequest);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, GET_URL,
                response -> Log.d("VolleyResponse GET", response),
                error -> Log.e("VolleyError", error.toString())
        );

        requestQueue.add(stringRequest);


    }
}