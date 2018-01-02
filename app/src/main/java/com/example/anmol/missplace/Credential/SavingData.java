package com.example.anmol.missplace.Credential;

import android.content.Context;
import android.content.SharedPreferences;
import com.example.anmol.missplace.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SavingData {

    Context ctx;
    JSONArray jsonArray;
    public SavingData(Context ctx){
        jsonArray = new JSONArray();
        this.ctx=ctx;
    }
    public void saveData(JSONArray jsonArray) throws JSONException {
        System.out.println(jsonArray);
        SharedPreferences sharedPref = ctx.getSharedPreferences(String.valueOf(R.string.DATA_HISTORY_FILE), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(String.valueOf(R.string.DATA_HISTORY), String.valueOf(jsonArray));
        editor.commit();
    }
    public String getData(){
        SharedPreferences sharedPref = ctx.getSharedPreferences(String.valueOf((R.string.DATA_HISTORY_FILE)), Context.MODE_PRIVATE);
        return sharedPref.getString(String.valueOf(R.string.DATA_HISTORY), "");
    }
}
