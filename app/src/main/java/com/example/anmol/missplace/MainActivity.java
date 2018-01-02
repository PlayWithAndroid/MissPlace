package com.example.anmol.missplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.anmol.missplace.Credential.SecurityPinNo;
import com.example.anmol.missplace.Credential.password;

public class MainActivity extends AppCompatActivity {

    EditText pass;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_lay);
        pass= findViewById(R.id.pass_edit);
        btn = findViewById(R.id.butt);
        password p =new password(MainActivity.this);
        final String pa = p.getPass();

        if (pa.equals("")){
            btn.setText("Save Password");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    savePassword(pass.getText().toString());
                    Intent i=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(i);
                }
            });
        }
        else{
            btn.setText("Login");
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (pass.getText().toString().equals(pa)){
                        Intent i=new Intent(MainActivity.this,SecondActivity.class);
                        startActivity(i);
                    }
                }
            });
        }
    }
    private void savePassword(String pass){
        password p1=new password(MainActivity.this);
        p1.setPass(pass);
    }
}
