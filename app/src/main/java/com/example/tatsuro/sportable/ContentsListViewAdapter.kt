package com.example.tatsuro.sportable

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ContentsListViewAdapter (private val list: List<ContentsListData>, private val listener: ListListener) : RecyclerView.Adapter<ContentsListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentsListViewHolder {
        val rowView: View = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ContentsListViewHolder(rowView)
    }

    override fun onBindViewHolder(holder: ContentsListViewHolder, position: Int) {
        holder.titleView.text = list[position].contentName
        holder.detailView.text = list[position].contentAddress
        holder.itemView.setOnClickListener {
            listener.onClickRow(it, list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ListListener {
        fun onClickRow(tappedView: View, rowModel: ContentsListData)
    }
}