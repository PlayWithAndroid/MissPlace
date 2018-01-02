package com.example.anmol.missplace;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.anmol.missplace.Adapters.mainAdapter;
import com.example.anmol.missplace.Credential.SavingData;
import com.example.anmol.missplace.Credential.SecurityPinNo;
import org.json.JSONArray;
import org.json.JSONException;

public class SecondActivity extends AppCompatActivity{

    private RecyclerView rv;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SecurityPinNo sp = new SecurityPinNo(SecondActivity.this);
        sp.setPinNo(String.valueOf((int)Math.random()*8000+1000));
        System.out.println("-------------------------------->PIN" + sp.getPinNo());
        initializinglayout();
        try {
            settingAdapter();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void initializinglayout(){
        rv = findViewById(R.id.my_recycler_view);
//        layoutManager = new LinearLayoutManager(getApplicationContext());
//        rv.setLayoutManager(layoutManager);
    }
    private void settingAdapter() throws JSONException {
        SavingData savingData = new SavingData(SecondActivity.this);
        String data = savingData.getData();
        System.out.println("DATA --------------------->" + data);
        //        JSONArray jsonArray=new JSONArray(data);
//        adapter = new mainAdapter(jsonArray);
//        rv.setAdapter(adapter);
    }
}
