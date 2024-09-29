package com.example.counterapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class ThirdActivity extends AppCompatActivity {


    TextView yourNumber, numberOutput;
    Button share_btn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        yourNumber = findViewById(R.id.yourNumber);
        numberOutput = findViewById(R.id.numberOutput);
        share_btn = findViewById(R.id.share_btn);

        //How to receive (GET) data from Second Activity from putExtra Method
        Intent i = getIntent();
        String username = i.getStringExtra("name");

        int random_num = generateRandomNumber();
        numberOutput.setText(""+random_num);


        //SHARING DATA to VARIOUS APPS OPTION

        share_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(username, random_num);
            }
        });

        };
    //Generate Random Numbers

    public int generateRandomNumber(){
        Random random = new Random();
        int upper_limit = 1000;
        int randomNumberGenerated = random.nextInt(upper_limit);
        return randomNumberGenerated;
    }

    public void shareData(String username, int randomNum ){
        //Implicit Intent
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        //Additional Info
        i.putExtra(Intent.EXTRA_SUBJECT,username + "Got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT, "Your lucky number is: " +randomNum);
        startActivity(Intent.createChooser(i, "Choose a Platform"));

    }
    }



