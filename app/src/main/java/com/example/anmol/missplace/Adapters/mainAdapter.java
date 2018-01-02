package com.example.anmol.missplace.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.anmol.missplace.R;

import java.util.ArrayList;

public class mainAdapter extends RecyclerView.Adapter<mainAdapter.ViewHolder> {


// Constructor
     public mainAdapter()
        {

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
    public mainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.card_first,parent,false));
    }

    @Override
    public void onBindViewHolder(mainAdapter.ViewHolder holder, int position) {


    }

    @Override
    public int getItemCount()
    {
        return 0;
    }
}