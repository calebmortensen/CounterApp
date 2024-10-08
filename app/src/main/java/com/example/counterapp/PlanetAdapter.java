package com.example.counterapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Planet> {
// Using Custom Layouts --> PlanetAdapter
// Using Custom Objects --> extends ArrayAdapter<Planet>

private ArrayList<Planet> planetArrayList;
Context context;

    public PlanetAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.planetlayout, planetArrayList);
        this.planetArrayList = planetArrayList;
        this.context = context;
    }

    private static class MyViewHolder{

        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       //1. Get planet object current position
        Planet planet = getItem(position);

        //2.  Inflate layout
        MyViewHolder myViewHolder;
        final View result;

        if(convertView == null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.planetlayout,
                    parent,
                    false
            );

            //Finding Views
            myViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            myViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moon_count_text);
            myViewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;

            convertView.setTag(myViewHolder);

        }else{
            // the view is recycled
            myViewHolder = (MyViewHolder)  convertView.getTag();
            result = convertView;
        }

        //Getting the data from model class (Planet)
        myViewHolder.planetName.setText(planet.getPlanetName());
        myViewHolder.moonCount.setText(planet.getMoonCount());
        myViewHolder.planetImg.setImageResource(planet.getPlanetImage());

        return result;
    }
}
