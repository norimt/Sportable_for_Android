package com.example.tatsuro.sportable

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RssListViewAdapter (
        private val context: Context,
        private val list: List<RssListData>,
        private val onItemClicked: (RssListData) -> Unit)
    : RecyclerView.Adapter<RssListViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RssListViewHolder {
        val rowView: View = inflater.inflate(R.layout.rss_simple_cell, parent, false)
        val viewHolder = RssListViewHolder(rowView)

        rowView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val article = list[position]
            onItemClicked(article)
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: RssListViewHolder, position: Int) {
//        holder.titleView.text = list?.get(position)!!.rssTitle
//        holder.contributorView.text = list?.get(position)!!.rssContributor
//
//        holder.itemView.setOnClickListener {
//            listener.onClickRow(it, list?.get(position)!!)
//        }
        val article = list[position]
        holder.title.text = article.title
        holder.pubDate.text = article.pubDate
    }

    override fun getItemCount() = list.size

//    interface ListListener {
//        fun onClickRow(tappedView: View, rowModel: RssListData)
//    }
}