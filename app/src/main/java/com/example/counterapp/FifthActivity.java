package com.example.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FifthActivity extends AppCompatActivity {

    DatePicker datePicker;
    Button dateBtn, nvgToSixth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fifth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        datePicker = findViewById(R.id.datePicker);
        dateBtn = findViewById(R.id.dateBtn);

        dateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String day = "Day " + datePicker.getDayOfMonth();
                String month = "Month " + (datePicker.getMonth()+1);
                String year = "Year " + datePicker.getYear();

                Toast.makeText(FifthActivity.this, day + " " + month + " " + year, Toast.LENGTH_LONG).show();
            }
        });
        nvgToSixth = findViewById(R.id.nvgToSixth);
        nvgToSixth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSixthActivity();
            }
        });

    }
    public void goToSixthActivity() {
        Intent intent = new Intent(this, SixthActivity.class);
        startActivity(intent);
    }

}