package com.example.anmol.missplace.Credential;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.anmol.missplace.R;

public class password {
    Context ctx;
    private password(Context ctx){
        this.ctx=ctx;
    }
    public void setPass(String pass){
        SharedPreferences sharedPref = ctx.getSharedPreferences(String.valueOf(R.string.Password_FILE), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(String.valueOf(R.string.Password),pass);
        editor.commit();
    }
    public String getPass(){
        SharedPreferences sharedPref = ctx.getSharedPreferences(String.valueOf((R.string.Password_FILE)), Context.MODE_PRIVATE);
        return sharedPref.getString(String.valueOf(R.string.Password), "");
    }
}
