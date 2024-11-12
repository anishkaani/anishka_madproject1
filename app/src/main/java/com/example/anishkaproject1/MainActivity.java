package com.example.anishkaproject1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnAddData, btnViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddData = findViewById(R.id.btnAddData);
        btnViewData = findViewById(R.id.btnViewData);

        btnAddData.setOnClickListener(view -> {
            // Navigate to AddDataActivity
            Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
            startActivity(intent);
        });

        btnViewData.setOnClickListener(view -> {
            // Navigate to ViewDataActivity
            Intent intent = new Intent(MainActivity.this, ViewDataActivity.class);
            startActivity(intent);
        });
    }
}
