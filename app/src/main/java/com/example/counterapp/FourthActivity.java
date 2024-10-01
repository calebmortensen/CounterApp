package com.example.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FourthActivity extends AppCompatActivity {


  Spinner spinner;
  TimePicker timePicker;
  Button nvgFifth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fourth);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);

        String[] courses = {"C++", "Java", "Kotlin", "Python"};

        //ArrayAdapter: used to populate the 'Spinner' with items from a string array resource
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                courses
        );

        //apply adapter to spinner

        spinner.setAdapter(adapter);



        timePicker = findViewById(R.id.timePicker);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                //Handle Time Change
                Toast.makeText(FourthActivity.this, "Hour: " + hourOfDay + " minute " + minute, Toast.LENGTH_LONG).show();
            }
        });

        nvgFifth = findViewById(R.id.nvgFifth);
        nvgFifth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFifthActivity();
            }
        });


    }
    public void goToFifthActivity() {
        Intent intent = new Intent(this, FifthActivity.class);
        startActivity(intent);
    }


}









