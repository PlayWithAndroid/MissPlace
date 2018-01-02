package com.example.anmol.missplace.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anmol.missplace.R;

import org.json.JSONArray;

import java.util.ArrayList;

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.ViewHolder> {

    JSONArray jsonArray;

    // Constructor
     public mainAdapter(JSONArray jsonArray)
        {
            this.jsonArray=jsonArray;
        }

/*
   View Holder class to instantiate views
 */
    class ViewHolder extends RecyclerView.ViewHolder{
        //View Holder Class Constructor
       public ViewHolder(View itemView)
    {
        super(itemView);
    }
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public mainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case 0:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_first,parent,false));
            case 1:
                return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(mainAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount()
    {
        return jsonArray.length()+1;
    }
}