package com.example.schedule

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.adapter.ControllerDayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var recyclerView:RecyclerView
    var mDays : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        recyclerView = findViewById(R.id.recyclerview)

        recyclerView.layoutManager =LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        loadDataDays()

        var adapter = ControllerDayAdapter(mDays, this.applicationContext)
        recyclerView.adapter =adapter

    }

    private fun loadDataDays() {
        for (x in 0..7) {
            when (x) {
                0 -> mDays.add("Domingo")
                1 -> mDays.add("Segunda")
                3 -> mDays.add("Terça-Feira")
                4 -> mDays.add("Quarta-Feira")
                5 -> mDays.add("Quinta-Feira")
                6 -> mDays.add("Sexta-Feira")
                7 -> mDays.add("Sábado")
            }
        }

       // startActivity(Intent(this, DayWeek.kt))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
