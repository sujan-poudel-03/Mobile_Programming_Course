package com.example.mobile_programming_course;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);

        String[] layoutTypes = {"Linear Layout", "Relative Layout", "Table Layout", "Constraint Layout"};

        ArrayAdapter<String> layoutAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, layoutTypes);

        ListView layoutList = findViewById(R.id.layout_types);
        layoutList.setAdapter(layoutAdapter);

        Toast.makeText(this, "Inside layout", Toast.LENGTH_SHORT).show();
        layoutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = null;

                switch (i){
                    case 0:
                        intent = new Intent(LayoutActivity.this, LinearLayout.class);
                        break;
                    case 1:
                        intent = new Intent(LayoutActivity.this, RelativeLayout.class);
                        break;
                    case 2:
                        intent = new Intent(LayoutActivity.this, TableLayout.class);
                        break;
                    case 3:
                        intent = new Intent(LayoutActivity.this, ConstraintLayout.class);
                        break;
                    default:
                        return;
                }

                startActivity(intent);
            }
        });

    }
}