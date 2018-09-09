//package com.example.tatsuro.sportable
//
//import android.content.Context
//import android.support.v7.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import java.text.FieldPosition
//
//class RssArticlesAdapter (
//    private val context: Context,
//    private val rssArticle: List<RssArticle>,
//    private val onArticleClicked: (RssArticle) -> Unit):RecyclerView.Adapter<RssArticlesAdapter.RssArticlesViewHolder>(){
//
//    private val inflater = LayoutInflater.from(context)
//
//    class RssArticlesViewHolder(view: View): RecyclerView.ViewHolder(view){
//        val rssImage = view.findViewById<ImageView>(R.id.rssImage)
//        val rssTitle = view.findViewById<TextView>(R.id.rssTitle)
//        val rssContributor = view.findViewById<TextView>(R.id.rssContributor)
//    }
//
//    override fun getItemCount() = rssArticle.size
//
//    override fun onCreateViewHolder(parent: ViewGroup ,viewType:Int): RssArticlesViewHolder {
//        val view = inflater.inflate(R.layout.rss_grid_cell,parent,false)
//        val rssViewHolder = RssArticlesViewHolder(view)
//
//        view.setOnClickListener{
//            val position = rssViewHolder.adapterPosition
//            val rssArticle = rssArticle[position]
//
//            onArticleClicked(rssArticle)
//        }
//        return rssViewHolder
//    }
//
//    override fun onBindViewHolder(holder: RssArticlesViewHolder,position: Int) {
//        val rssArticle = rssArticle[position]
//        holder.rssTitle.text = rssArticle.rssTitle
//        holder.rssContributor.text = rssArticle.rssContributor
//    }
//}