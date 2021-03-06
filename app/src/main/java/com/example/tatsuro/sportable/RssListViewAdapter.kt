package com.example.tatsuro.sportable

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RssListViewAdapter (private val list: List<RssListData>?, private val listener: ListListener) : RecyclerView.Adapter<RssListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssListViewHolder {
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.rss_grid_cell, parent, false)
        return RssListViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: RssListViewHolder, position: Int) {
        holder.titleView.text = list?.get(position)!!.rssTitle
        holder.contributorView.text = list?.get(position)!!.rssContributor

        holder.itemView.setOnClickListener {
            listener.onClickRow(it, list?.get(position)!!)
        }
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    interface ListListener {
        fun onClickRow(tappedView: View, rowModel: RssListData)
    }
}