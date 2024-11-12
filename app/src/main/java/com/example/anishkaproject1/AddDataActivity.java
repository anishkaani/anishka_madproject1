package com.example.anishkaproject1;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddDataActivity extends AppCompatActivity {

    EditText editTextName;
    Button btnSave;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        // Initialize UI components
        editTextName = findViewById(R.id.editTextName);
        btnSave = findViewById(R.id.btnSave);

        // Initialize DatabaseHelper instance
        DB = new DatabaseHelper(this);

        // Set up button click listener
        btnSave.setOnClickListener(view -> {
            // Get text from the EditText
            String name = editTextName.getText().toString();

            // Check if input is empty
            if (name.isEmpty()) {
                Toast.makeText(AddDataActivity.this, "Name cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            // Insert data into the database
            boolean isInserted = DB.insertData(name);

            // Show a message based on whether the data was inserted or not
            if (isInserted) {
                Toast.makeText(AddDataActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                editTextName.setText("");  // Clear the input field
            } else {
                Toast.makeText(AddDataActivity.this, "Data Not Saved", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
