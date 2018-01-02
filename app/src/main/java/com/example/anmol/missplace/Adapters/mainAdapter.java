package com.example.anmol.missplace.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.anmol.missplace.Credential.SecurityPinNo;
import com.example.anmol.missplace.R;
import com.example.anmol.missplace.SecondActivity;
import com.example.anmol.missplace.utils.operationOnCal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class mainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    JSONArray jsonArray;
    Context ctx;

     public mainAdapter(JSONArray jsonArray,Context ctx)
        {
            this.jsonArray=jsonArray;
            this.ctx=ctx;
        }


    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return 0;
        }
        else{
            return 1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v;
        switch (viewType){
            case 0:
               v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_first,parent,false);
                return new ViewHolder(v);
            case 1:
               v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
                return new ViewHolderone(v);
        }
        return null;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        Button Change;
        TextView PinNo;
        public ViewHolder(View itemView)
        {
            super(itemView);
            Change = itemView.findViewById(R.id.changeButton);
            PinNo = itemView.findViewById(R.id.SecurityPinNo);

            final SecurityPinNo s =new SecurityPinNo(ctx);
            PinNo.setText(s.getPinNo());

            Change.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        s.setPinNo(String.valueOf((int)(Math.random()*8000+1000)));
                        PinNo.setText(s.getPinNo());
                    Toast.makeText(ctx,"changed",Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    class ViewHolderone extends RecyclerView.ViewHolder{

        TextView Month;
        TextView Date;
        TextView rt;
        public ViewHolderone(View itemView)
        {
            super(itemView);
            Month = itemView.findViewById(R.id.Month);
            Date = itemView.findViewById(R.id.Date);
            rt = itemView.findViewById(R.id.requestType);
        }
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if (holder.getItemViewType()==1){
             try {
                 ViewHolderone h = (ViewHolderone) holder;
                 JSONObject jsonObject = (JSONObject) jsonArray.get(position);
                 operationOnCal onCal = new operationOnCal();
                 h.Month.setText(onCal.getMonth(jsonObject.getInt("month")));
                 h.Date.setText(onCal.getProperDate(jsonObject.getInt("date")));
                 String name = jsonObject.getString("msg").replaceAll("[0-9]", "").replace("name", "").replaceAll("\\s+","").replace("mpla","");
                 h.rt.setText("Phone Number of "+name);
             } catch (JSONException e) {
                 e.printStackTrace();
             }
         }
    }

    @Override
    public int getItemCount()
    {
        return jsonArray.length();
    }
}