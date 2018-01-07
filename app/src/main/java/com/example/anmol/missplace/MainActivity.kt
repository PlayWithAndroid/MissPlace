package com.example.anmol.missplace

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.anmol.missplace.Credential.password

class MainActivity : AppCompatActivity() {

    internal lateinit var pass: EditText
    internal lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_lay)
        pass = findViewById(R.id.pass_edit)
        btn = findViewById(R.id.butt)
        val p = password(this@MainActivity)
        val pa = p.pass

        if (pa == "") {
            btn.text = "Save Password"
            btn.setOnClickListener {
                savePassword(pass.text.toString())
                val i = Intent(this@MainActivity, SecondActivity::class.java)
                startActivity(i)
            }
        } else {
            btn.text = "Login"
            btn.setOnClickListener {
                if (pass.text.toString() == pa) {
                    val i = Intent(this@MainActivity, SecondActivity::class.java)
                    startActivity(i)
                }
            }
        }
    }

    private fun savePassword(pass: String) {
        val p1 = password(this@MainActivity)
        p1.pass = pass
    }
}
