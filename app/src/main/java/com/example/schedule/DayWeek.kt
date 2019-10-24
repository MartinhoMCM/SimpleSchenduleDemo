package com.example.schedule

import android.database.Cursor
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SimpleCursorAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedule.adapter.*;
import com.example.schedule.teammodel.modelNotes

import kotlinx.android.synthetic.main.activity_day_week.*
import kotlinx.android.synthetic.main.savelayout.*


class DayWeek : AppCompatActivity() {

    var mNotes: ArrayList<modelNotes> = ArrayList()
    lateinit var adapter:notesAdapter
    lateinit var recycler:RecyclerView

    var day = "Segunda"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day_week)
        setSupportActionBar(toolbar)
         recycler =findViewById(R.id.recyclerViewSave)
         recycler.layoutManager =LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter =notesAdapter(this, mNotes)
        adapter.notifyDataSetChanged()


        if(mNotes.size==0)
        {
            recycler.visibility=View.GONE
        }

     //   var bundle :Bundle ?=intent.extras

        if(day!=null)
        {
            day =intent.getStringExtra("day")
        }


        supportActionBar!!.title =day
        saveDisplayData()

    }

    private fun saveDisplayData() {

        var editTitle = findViewById<TextView>(R.id.editTitle)
        var editDesc = findViewById<TextView>(R.id.editDescription)
        var save = findViewById<TextView>(R.id.save)
        var dbHelper = DbHelper(this)
        fectData()
        save.setOnClickListener(View.OnClickListener {
    if(editTitle.text.isEmpty() || editDesc.text.isEmpty())
    {
        Toast.makeText(this, "Can not save it!", Toast.LENGTH_LONG).show()
    }
    else{
        dbHelper.insert(editTitle.text.toString(), editDescription.text.toString(), day)
        var modelNote = modelNotes(editTitle.text.toString(), editDescription.text.toString())
       // mNotes.add(modelNote)

        fectData()
        editTitle.text=""
        editDesc.text=""
        }
        })
    }

    private fun fectData() {
        /*var editTitle = findViewById<TextView>(R.id.editTitle)
        var editDesc = findViewById<TextView>(R.id.editDescription)
        var save = findViewById<TextView>(R.id.save)*/
        var dbHelper = DbHelper(this)
        var cursor = dbHelper.fetchAllData(day)

        if (cursor != null) {
            while (cursor.moveToNext()) {
                var modelNote = modelNotes(cursor.getString(1), cursor.getString(2))
                mNotes.add(modelNote)
            }

            recycler.visibility = View.VISIBLE
            adapter = notesAdapter(this, mNotes)
            adapter.notifyDataSetChanged()
            recycler.adapter = adapter
        }
    }

    override fun onResume() {
        super.onResume()
       adapter.notifyDataSetChanged()
        Log.d("mNotes","" +mNotes.size)
    }

}
