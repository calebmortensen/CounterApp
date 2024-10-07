package com.example.counterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Market extends AppCompatActivity implements MarketItemClickListener{


    RecyclerView recyclerView;

    List<MarketItem> itemList;

    MarketAdapter marketAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);


            recyclerView = findViewById(R.id.recyclerView);

            itemList = new ArrayList<>();
            MarketItem item1 = new MarketItem(R.drawable.feather1, "Feathers", "Feather from Internet");
            MarketItem item2 = new MarketItem(R.drawable.cube, "Cube", "Cube from Class");
            MarketItem item3 = new MarketItem(R.drawable.dice, "Dice", "Dice from work");
            MarketItem item4 = new MarketItem(R.drawable.feather2, "Feather2", "Feather2");
            MarketItem item5 = new MarketItem(R.drawable.cylinder, "Cyclinder", "Cyclinder");
            MarketItem item6 = new MarketItem(R.drawable.earth, "Earth", "Earth");

             itemList.add(item1);
             itemList.add(item2);
             itemList.add(item3);
             itemList.add(item4);
             itemList.add(item5);
             itemList.add(item6);

             LinearLayoutManager layoutManager = new LinearLayoutManager(this);
             recyclerView.setLayoutManager(layoutManager);








             marketAdapter = new MarketAdapter(itemList);
             recyclerView.setAdapter(marketAdapter);


                marketAdapter.setMarketItemClickListener(this);


        }

    @Override
    public void onClick(View v, int pos) {
        Toast.makeText(this, "You Chose: "+ itemList.get(pos).getItemName(), Toast.LENGTH_SHORT).show();
    }
}