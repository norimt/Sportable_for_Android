package com.example.tatsuro.sportable

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import okhttp3.OkHttpClient
import okhttp3.Request
import android.os.AsyncTask
import android.support.customtabs.CustomTabsIntent
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.picasso.Picasso


class NewsFragment : Fragment(), LoaderManager.LoaderCallbacks<List<RssListData>> {

    private lateinit var recyclerView : RecyclerView

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("xtc", "onActivityCreated called")
        super.onActivityCreated(savedInstanceState)
        loaderManager.initLoader(1, null, this)
    }

    override fun onCreateLoader(p0: Int, p1: Bundle?) : RssLoader {
        Log.d("xtc", "onCreaeLoader called")
        var ctx: Context? = activity?.applicationContext
        if (ctx != null) {
            Log.d("xtc", "context EXISTS")
        } else {
            Log.d("xtc", "context is NULL")
        }
        return RssLoader(activity!!.applicationContext) // TODO: 他にやりようがあるはず
    }
    override fun onLoaderReset(p0: Loader<List<RssListData>>) {
        // nothing to do
    }

    override fun onLoadFinished(loader: Loader<List<RssListData>>, data: List<RssListData>?) {
        Log.d("xtc", "onLoadFinished called")
        // TODO: この時点で recyclerView に値入ってる? つまりここが呼ばれるのは onCreateView のあとになってる?
        if (data != null) {
            Log.d("xtc", "onLoadFinished with data")
            val ctx = context ?: return
            Log.d("xtc", "onLoadFinished with context")
            val adapter = RssListViewAdapter(ctx, data) { article ->
                //
            }
            recyclerView.adapter = adapter
            val layoutManager = GridLayoutManager(ctx,2)
            recyclerView.layoutManager = layoutManager
        } else {
            Log.d("xtc", "onLoadFinished without context")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.news_fragment, container, false)
        recyclerView = view.findViewById(R.id.RssListView)
        Log.d("xtc", "onCreateView called")
        return view
    }
    companion object {
        fun newInstance(): NewsFragment {
            val fragment = NewsFragment()
            return fragment
        }
    }

//    inner class MyAsyncTask: AsyncTask<Void, Void, String>() {
//
//        override fun doInBackground(vararg p0: Void?): String {
//            return this.getHtml()
//        }
//
//        override fun onPostExecute(result: String) {
//            super.onPostExecute(result)
//            val recyclerView = view?.findViewById(R.id.RssListView) as RecyclerView
//            val adapter = RssListViewAdapter(createDataList(result), object : RssListViewAdapter.ListListener {
//                override fun onClickRow(tappedView: View, RssListData: RssListData) {
//                    this@NewsFragment.onClickRow(RssListData)
//                }
//            })
//
//            recyclerView.setHasFixedSize(true)
//            recyclerView.layoutManager = GridLayoutManager(activity, 2)
//            recyclerView.adapter = adapter
//        }
//
//        fun getHtml(): String {
//            val client = OkHttpClient()
//            val req = Request.Builder().url("https://api.myjson.com/bins/13fw2o").get().build()
//            val resp = client.newCall(req).execute()
//
//
//            return resp.body()!!.string()
//        }
//    }
//     fun createDataList(result:String): List<RssListData>? {
//         val jsonText = result
//         val rssMapType = Types.newParameterizedType(
//                 Map::class.java,
//                 String::class.java,
//                 Rss::class.java
//         )
//         val rssMapAdapter: JsonAdapter<Map<String, Rss>> = Moshi.Builder()
//                 .build()
//                 .adapter(rssMapType)
//
//         val rssMap: Map<String, Rss>? = rssMapAdapter.fromJson(jsonText)
//
//         val dataList = rssMap?.map { (key, rss) ->
//             RssListData().also {
//                 it.rssTitle = rss.rssTitle
//                 it.rssContributor = rss.rssContributor
//                 it.rssUrl = rss.rssUrl
//                 //Picasso.with(imageView.context).load(rss.rssUrl).into(rssImage)
//                 //Picasso.with(context).load(rss.rssUrl).fit().centerCrop().into(rssImage)
//
//             }
//         }
//         return dataList
//     }
//    fun onClickRow(rowModel: RssListData) {
//        val intent = CustomTabsIntent.Builder().build()
//                    intent.launchUrl(getActivity(), Uri.parse(rowModel.rssUrl))
//    }
}

