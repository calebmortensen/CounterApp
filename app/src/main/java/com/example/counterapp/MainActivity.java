package com.example.counterapp;

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

public class MainActivity extends AppCompatActivity {

    EditText convertertext;
    TextView textView, counter_text, unitconverter_text;
    Button btn, btn_converter;
    int counter = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        btn = findViewById(R.id.btn);
        counter_text = findViewById(R.id.counter_text);
        textView = findViewById(R.id.textView);

        unitconverter_text = findViewById(R.id.unitconverter_text);
        btn_converter = findViewById(R.id.btn_converter);
        convertertext = findViewById(R.id.convertertext);

        //Add Functionality
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            textView.setText(""+increaseCounter());
            }
        });

        btn_converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Gets user input (kilos)
            String inputText = convertertext.getText().toString();

            //Convert String to double
            double kilos = Double.parseDouble(inputText);

            //Convert Kilos to pounds
            double pounds = makeConversion(kilos);

            //Display the conversion result
                convertertext.setText("" + pounds);

            }
        });

        }

    public int increaseCounter() {
        return ++counter;
    }

    public double makeConversion(double kilos){

        // 1 kilo = 2.20462 pounds

        return kilos * 2.20462;
    }


    }