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

//Responsible for creating the view for each item binding data to it
public class VolumeAdapter extends ArrayAdapter<Shape> {


    private ArrayList<Shape> shapeArrayList;
    Context context;


    public VolumeAdapter(ArrayList<Shape> shapeArrayList, Context context) {
        super(context, R.layout.grid_item_layout, shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context;

    }

    //View Holder: Used to cache references to the views with an item layout

    private static class MyViewHolder{
        TextView shapeName;
        ImageView shapeImg;
    }

//GetView: Used to create and return a view for a specific item in Grid


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //Get the shape object for current position
        Shape shapes = getItem(position);

        //Inflate Layout
        MyViewHolder myViewHolder;

        if(convertView == null){
                myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(
                    R.layout.grid_item_layout,
                    parent,
                    false
            );
            myViewHolder.shapeName =(TextView) convertView.findViewById(R.id.textView);
            myViewHolder.shapeImg =(ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(myViewHolder);

        }else{
            //a view went off-screen -> reuse it
            myViewHolder = (MyViewHolder) convertView.getTag();

        }

        //Get data from model class (Shape)
        myViewHolder.shapeName.setText(shapes.getShapeName());
        myViewHolder.shapeImg.setImageResource(shapes.getShapeImg());

        return convertView;
    }
}
