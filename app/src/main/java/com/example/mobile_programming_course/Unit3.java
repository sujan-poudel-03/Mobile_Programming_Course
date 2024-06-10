package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Unit3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit3);

        String[] chapterContents = {"Layout & its Attributes", "Widgets & its Attributes", "String, Array and Colors"};

        ArrayAdapter<String> chapterContent = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chapterContents);

        ListView contentList = findViewById(R.id.chapter3_contents);

        contentList.setAdapter(chapterContent);

        contentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;

                switch (i) {
                    case 0:
                        intent = new Intent(Unit3.this, LayoutActivity.class);
                        break;
                    default:
                        return;
                }

                startActivity(intent);
            }
        });

    }
}