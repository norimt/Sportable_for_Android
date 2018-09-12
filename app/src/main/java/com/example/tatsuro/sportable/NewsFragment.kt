package com.example.tatsuro.sportable

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import okhttp3.OkHttpClient
import okhttp3.Request
import android.os.AsyncTask
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.tatsuro.sportable.R.id.rssContributor
import com.example.tatsuro.sportable.R.id.rssTitle
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types


class NewsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.news_fragment, container, false)
        MyAsyncTask().execute()
        return view
    }
    companion object {
        fun newInstance(): NewsFragment {
            val fragment = NewsFragment()
            return fragment
        }
    }

    inner class MyAsyncTask: AsyncTask<Void, Void, String>() {

        override fun doInBackground(vararg p0: Void?): String {
            return this.getHtml()
        }

        override fun onPostExecute(result: String) {
            super.onPostExecute(result)
            val recyclerView = view?.findViewById(R.id.RssListView) as RecyclerView
            val adapter = RssListViewAdapter(createDataList(result), object : RssListViewAdapter.ListListener {
                override fun onClickRow(tappedView: View, RssListData: RssListData) {
                    this.onClickRow(tappedView, RssListData)
                }
            })

            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = GridLayoutManager(activity, 2)
            recyclerView.adapter = adapter
        }

        fun getHtml(): String {
            val client = OkHttpClient()
            val req = Request.Builder().url("https://api.myjson.com/bins/jqbbk").get().build()
            val resp = client.newCall(req).execute()

            return resp.body()!!.string()
        }
    }
     fun createDataList(result:String): List<RssListData>? {
         val jsonText = result
         val rssMapType = Types.newParameterizedType(
                 Map::class.java,
                 String::class.java,
                 Rss::class.java
         )
         val rssMapAdapter: JsonAdapter<Map<String, Rss>> = Moshi.Builder()
                 .build()
                 .adapter(rssMapType)

         val rssMap: Map<String, Rss>? = rssMapAdapter.fromJson(jsonText)

// あとは適当にループして目的のデータに変換してください
         val dataList = rssMap?.map { (key, rss) ->
             println("$rssMap+66666666666666666666666")
             RssListData().also {
                 it.rssTitle = rss.rssTitle
                 it.rssContributor = rss.rssContributor
                 it.rssUrl = rss.rssUrl
             }
         }
         println("$dataList+88888888888888888888888888888888888")
         return dataList
     }
}


