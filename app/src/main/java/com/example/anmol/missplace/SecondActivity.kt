package com.example.anmol.missplace

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log.println
import com.example.anmol.missplace.Adapters.mainAdapter
import com.example.anmol.missplace.Credential.SavingData
import com.example.anmol.missplace.Credential.SecurityPinNo
import org.json.JSONArray
import org.json.JSONException

class SecondActivity : AppCompatActivity() {

    private var rv: RecyclerView? = null
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<*>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sp = SecurityPinNo(this@SecondActivity)
        if (sp.pinNo !== "") {
            sp.pinNo = (Math.random() * 8000 + 1000).toInt().toString()
        }
        initializinglayout()
        try {
            settingAdapter()
        } catch (e: JSONException) {
            e.printStackTrace()
        }

    }

    private fun initializinglayout() {
        rv = findViewById(R.id.my_recycler_view)
        layoutManager = LinearLayoutManager(applicationContext)
        rv!!.layoutManager = layoutManager
    }

    private fun settingAdapter() {
        val savingData = SavingData(this@SecondActivity)
        val data = savingData.data
        val jsonArray = JSONArray(data)
        adapter = mainAdapter(jsonArray, this@SecondActivity)
        rv!!.adapter = adapter
    }
}
