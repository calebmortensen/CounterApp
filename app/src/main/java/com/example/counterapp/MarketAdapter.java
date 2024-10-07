package com.example.counterapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MarketViewHolder> {


    private List<MarketItem> itemList;

    public MarketItemClickListener marketItemClickListener;

    public void setMarketItemClickListener(MarketItemClickListener myListener){
        this.marketItemClickListener = myListener;
    }



    public MarketAdapter(List<MarketItem> itemList) {
        this.itemList = itemList;
    }




    @NonNull
    @Override
    public MarketViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.market_item_layout, parent, false);

        return new MarketViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MarketViewHolder holder, int position) {

        MarketItem item = itemList.get(position);
        holder.title.setText(item.getItemName());
        holder.description.setText(item.getItemDesc());
        holder.imageView.setImageResource(item.getItemImg());
    }

    @Override
    public int getItemCount() {


        return itemList.size();
    }


    public class MarketViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
            //Holds references to the views within the item layout
        ImageView imageView;
        TextView title;
        TextView description;


    public MarketViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.marketimage);
        title = itemView.findViewById(R.id.markettitle);
        description = itemView.findViewById(R.id.marketdescription);


        itemView.setOnClickListener(this);
    }

        @Override
        public void onClick(View v) {
            if(marketItemClickListener != null){
                marketItemClickListener.onClick(v, getAdapterPosition());
            }
        }
    }

}
