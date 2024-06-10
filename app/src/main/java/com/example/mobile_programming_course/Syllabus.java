package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Syllabus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        String[] chapter = {"Chapter 1", "Chapter 2", "Chapter 3"};

        ArrayAdapter<String> chapterAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, chapter);

        ListView listView =(ListView) findViewById(R.id.chapter_list);

        listView.setAdapter(chapterAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                // Create a Intent to redirect or Start each content on ArrayAdapter
                Intent intent = null;
                switch (i){
                    case 2:
                        intent = new Intent(Syllabus.this, Unit3.class);
                        break;
                    default:
                        return;
                }

                intent.putExtra("chapter_name", chapter[i]);
                startActivity(intent);
            }
        });

    }
}