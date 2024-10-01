package com.example.counterapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SeventhActivity extends AppCompatActivity implements View.OnClickListener{

    Button blackBtn, greenBtn, purpleBtn, redBtn, yellowBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seventh);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        blackBtn = findViewById(R.id.blackBtn);
        greenBtn = findViewById(R.id.greenBtn);
        purpleBtn = findViewById(R.id.purpleBtn);
        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);

        redBtn.setOnClickListener(this);
        blackBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        purpleBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        //Find the button by ID and play the correct sound
        int clickedBtnId = v.getId();

        if (clickedBtnId == R.id.blackBtn) {
            PlaySounds(R.raw.noir);
        }else if(clickedBtnId == R.id.greenBtn){
            PlaySounds(R.raw.verte);
        }else if(clickedBtnId == R.id.purpleBtn){
            PlaySounds(R.raw.violet);
        }else if(clickedBtnId == R.id.redBtn){
            PlaySounds(R.raw.rouge);
        }else if(clickedBtnId == R.id.yellowBtn){
            PlaySounds(R.raw.jaune);
        }
    }

    public void PlaySounds(int id) {
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
                id
        );
        mediaPlayer.start();

    }
}