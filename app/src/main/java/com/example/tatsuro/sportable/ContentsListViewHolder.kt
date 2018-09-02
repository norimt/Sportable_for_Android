package com.example.tatsuro.sportable

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class ContentsListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(R.id.contentName)
    val detailView: TextView = itemView.findViewById(R.id.contentAddress)
}