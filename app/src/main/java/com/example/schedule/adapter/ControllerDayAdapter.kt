package com.example.schedule.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import  com.example.schedule.*

class  ControllerDayAdapter(private  val mDayList : ArrayList<String>, context: Context):
    RecyclerView.Adapter<ControllerDayAdapter.ViewHolder>()
{


    var viewGroup:ViewGroup?=null

    var mContext:Context?=context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        viewGroup =parent;
        var v =LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent,
            false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return mDayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var day =mDayList.get(position)
        holder.mDay.setText(day)

        //Ativar a funcao click
        holder.itemView.setOnClickListener(View.OnClickListener {

            var intent:Intent =Intent(viewGroup!!.context, DayWeek::class.java)

            intent.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("day",day)
            mContext!!.startActivity(intent)


        })
    }


    class  ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView)
    {

        var mDay:TextView = itemView.findViewById(R.id.mDay);

    }
}