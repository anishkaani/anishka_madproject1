package com.example.anishkaproject1;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ViewDataActivity extends AppCompatActivity {
    TextView textViewData;
    DatabaseHelper DB;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        textViewData = findViewById(R.id.textViewData);
        DB = new DatabaseHelper(this);

        try (Cursor cursor = DB.getData()) {
            StringBuilder stringBuilder = new StringBuilder();
            if (cursor.getCount() == 0) {
                textViewData.setText("No Data Available");
            } else {
                while (cursor.moveToNext()) {
                    stringBuilder.append("ID: ").append(cursor.getInt(0))
                            .append(", Name: ").append(cursor.getString(1)).append("\n");
                }
                textViewData.setText(stringBuilder.toString());
            }
        }
        // Always close the cursor to release resources
    }
}
