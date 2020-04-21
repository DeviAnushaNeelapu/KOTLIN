package com.example.catfacts

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(val context: Context, val list:MutableList<MyData>):
    RecyclerView.Adapter<MyAdapter.RecyclerViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        return RecyclerViewHolder(LayoutInflater.from(context).inflate(R.layout.row,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.t.text=(list.get(position).title)
    }
    class RecyclerViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)  {
        val t = itemView.findViewById<TextView>(R.id.rtext1)

    }

}