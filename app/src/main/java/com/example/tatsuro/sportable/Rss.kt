package com.example.tatsuro.sportable

import android.content.Context
import android.support.v4.content.AsyncTaskLoader
import android.util.Log
import org.json.JSONObject
import java.io.InputStream
import java.io.InputStreamReader
import java.io.BufferedReader


//data class Rss(
//        @field:Json(name = "title")  var rssTitle: String,
//        @field:Json(name = "author") var rssContributor: String,
//        @field:Json(name = "link")   var rssUrl: String
//)


//data class Rss(val articles: List<Article>)

fun parseRss(stream: InputStream)  : List<RssListData> {
    Log.d("xtc", "parseRss called")
    val reader = BufferedReader(InputStreamReader(stream))
    val json = stream.bufferedReader().use { it.readText() }

//    val json = JSONObject(responseStrBuilder.toString())

    val obj = JSONObject(json)
    val items = obj.getJSONArray("items")

    val articles = arrayListOf<RssListData>()
    for (i in 0 until items.length()) {
        val item= items.getJSONObject(i)
        val article = RssListData(
                item.getString("title"),
                item.getString("link"),
                item.getString("pubDate")
        )
        articles.add(article)
    }
//    return Rss(articles)
    return articles
}

class RssLoader(context: Context) : AsyncTaskLoader<List<RssListData>>(context) {
    private var cache : List<RssListData>? = null

    override fun loadInBackground(): List<RssListData>? {
        Log.d("xtc", "loadInBackground called")
        val response = httpGet("https://api.rss2json.com/v1/api.json?rss_url=https%3A%2F%2Fwww.nikkansports.com%2Fbaseball%2Fmlb%2Fatom.xml")
        if (response != null) {
            Log.d("xtc", "loadInBackground got Response")
            return parseRss(response)
        }
        return null
    }

    override fun deliverResult(data: List<RssListData>?) {
        if (isReset || data == null) return

        cache = data
        super.deliverResult(data)
    }

    override fun onStartLoading() {
        Log.d("xtc", "onStartLoading called")
        if (cache != null) deliverResult(cache)
        if (takeContentChanged() || cache == null) forceLoad()
    }

    override fun onStopLoading() {
        cancelLoad()
    }

    override fun onReset() {
        super.onReset()
        onStopLoading()
        cache = null
    }
}

