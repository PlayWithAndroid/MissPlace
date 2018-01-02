package com.example.anmol.missplace.Credential;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.anmol.missplace.R;

public class SecurityPinNo {
    Context ctx;
    public SecurityPinNo(Context ctx){
        this.ctx=ctx;
    }
    public void setPinNo(String pin){
        SharedPreferences sharedPref = ctx.getSharedPreferences(String.valueOf(R.string.PIN_FILE), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(String.valueOf(R.string.Pin),pin);
        editor.commit();
    }
    public String getPinNo(){
        SharedPreferences sharedPref = ctx.getSharedPreferences(String.valueOf((R.string.PIN_FILE)), Context.MODE_PRIVATE);
        return sharedPref.getString(String.valueOf(R.string.Pin), "");
    }
}
