package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class Sphere extends AppCompatActivity {

    EditText sphereRadius;
    TextView title, result;
    Button sphereButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sphere);


        sphereRadius = findViewById(R.id.editText_sphere);
        title = findViewById(R.id.sphere_title);
        result = findViewById(R.id.sphere_result);
        sphereButton = findViewById(R.id.sphere_button);

        sphereButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radius = sphereRadius.getText().toString();

                int r = Integer.parseInt(radius);
                //V = (4/3) * pi * r^3

                double volume = (4/3) * 3.14159 * r * r * r;
                result.setText("V = " + volume+ " m^3");

            }
        });

        };
    }
