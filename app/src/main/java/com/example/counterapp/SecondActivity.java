package com.example.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    EditText enter_name;
    Button btn_wish;
    TextView welcomeNumber;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Initialize Widgets
        welcomeNumber = findViewById(R.id.welcomeNumber);
        enter_name = findViewById(R.id.enter_name);
        btn_wish = findViewById(R.id.btn_wish);

        //Functions -> Pass DATA between Activities

        btn_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = enter_name.getText().toString();
                //Explicit Intent -> Will be sending data to Third Activity
                Intent i = new Intent(
                        getApplicationContext(),
                        ThirdActivity.class
                );
                //Passing name to third activity
                i.putExtra("name", userName);
                startActivity(i);
            }
        });

    };
    }