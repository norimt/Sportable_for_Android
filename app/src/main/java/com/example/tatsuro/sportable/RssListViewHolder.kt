package com.example.tatsuro.sportable

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class RssListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
//    val titleView: TextView = itemView.findViewById(R.id.rssTitle)
//    val contributorView: TextView = itemView.findViewById(R.id.rssContributor)
//    val imageUrl: ImageView = itemView.findViewById(R.id.rssImage)
    val title = itemView.findViewById<TextView>(R.id.title)
    val pubDate = itemView.findViewById<TextView>(R.id.pubDate)
}