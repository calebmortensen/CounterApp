package com.example.counterapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;


public class Planets extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static PlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.planetlayout);


        //1 AdapterView : a ListView
        listView = findViewById(R.id.listview);

        //2 Data Source: ArrayList<Planet>
        planetsArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Mercury", "0 Moons", R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "0 Moons", R.drawable.venus);
        Planet planet3 = new Planet("Earth", "1 Moons", R.drawable.earth);

        Planet planet4 = new Planet("Mars", "2 Moons", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "79 Moons", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn","83 Moons", R.drawable.saturn);

        Planet planet7 = new Planet("Mercury", "27 Moons", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "14 Moons", R.drawable.neptune);


        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);
        planetsArrayList.add(planet5);
        planetsArrayList.add(planet6);
        planetsArrayList.add(planet7);
        planetsArrayList.add(planet8);


        //Adapter
       adapter = new PlanetAdapter(planetsArrayList, getApplicationContext());

    }

}