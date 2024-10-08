package com.example.counterapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText convertertext;
    TextView textView, counter_text, unitconverter_text;
    Button btn, btn_converter, btn_converter_clear, btn_dec, nvg, openBrowser, nvgFourth, frenchteacher, planets, volume, market;
    int counter = 0;
    CheckBox checkBox;
    RadioGroup radioGroup;
   // RadioButton radioButton;


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
        btn_converter_clear = findViewById(R.id.btn_converter_clear);
        btn_dec = findViewById(R.id.btn_dec);
        nvg = findViewById(R.id.nvg);
        openBrowser = findViewById(R.id.openBrowser);
        checkBox = findViewById(R.id.checkbox);
        radioGroup = findViewById(R.id.radioGroup);
        nvgFourth = findViewById(R.id.nvgFourth);
        frenchteacher = findViewById(R.id.frenchteacher);
        planets = findViewById(R.id.planets);
        volume = findViewById(R.id.volume);
        market = findViewById(R.id.market);




        //Add Functionality
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("" + increaseCounter());
            }
        });

        btn_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("" + decreaseCounter());
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

                //ACTION ITEM: Need to account for Non-Digits & Empty space for APP CRASH
            }


        });
        btn_converter_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertertext.setText("");
            }
        });

        nvg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });

        nvgFourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFourthActivity();
            }
        });

        frenchteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {goToSeventhActivity(); }
        });

        planets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {planets(); }
        });

        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {volume(); }
        });

        market.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {market(); }
        });

        openBrowser.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                openWebPage();
            }
        });

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(MainActivity.this, "Checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Not Checked", Toast.LENGTH_SHORT).show();
                }
            }
        });

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);
                Toast.makeText(MainActivity.this, "You Selected: "+radioButton.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });



    }



    public int increaseCounter() {
        return ++counter;
    }

    public int decreaseCounter() {
        return --counter;
    }

    public double makeConversion(double kilos) {
        // 1 kilo = 2.20462 pounds
        return kilos * 2.20462;
    }

    public void goToSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void market() {
        Intent intent = new Intent(this, Market.class);
        startActivity(intent);
    }

    public void goToFourthActivity() {
        Intent intent = new Intent(this, FourthActivity.class);
        startActivity(intent);
    }

    public void goToSeventhActivity() {
        Intent intent = new Intent(this, SeventhActivity.class);
        startActivity(intent);
    }

    public void planets() {
        Intent intent = new Intent(this, Planets.class);
        startActivity(intent);
    }

    public void volume() {
        Intent intent = new Intent(this, VolumeArea.class);
        startActivity(intent);
    }

    public void openWebPage() {
        Uri webpage = Uri.parse("https://www.gogle.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_home) {
            Toast.makeText(this, "You selected Home", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.action_search) {
            Toast.makeText(this, "You selected Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}