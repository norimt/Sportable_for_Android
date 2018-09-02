package com.example.tatsuro.sportable

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.support.v7.widget.RecyclerView



class ShopsFragment : Fragment() {

    companion object {

        fun newInstance(): ShopsFragment {
            val fragment = ShopsFragment()
            val args = Bundle()
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = arguments
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.shops_fragment, container, false)

            super.onViewCreated(view, savedInstanceState)

            val recyclerView = view.findViewById(R.id.contentsListView) as RecyclerView
            val adapter = ContentsListViewAdapter(createDataList(), object : ContentsListViewAdapter.ListListener {
                override fun onClickRow(tappedView: View, ContentsListData: ContentsListData) {
                    this.onClickRow(tappedView, ContentsListData)
                }
            })

            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = adapter
        return view
        }


        private fun createDataList(): List<ContentsListData> {

            val dataList = mutableListOf<ContentsListData>()
            for (i in 0..49) {
                val data: ContentsListData = ContentsListData().also {
                    it.contentName = "タイトル" + i + "だよ"
                    it.contentAddress = "詳細" + i + "個目だよ"
                }
                dataList.add(data)
            }
            return dataList
        }


        fun onClickRow(tappedView: View, rowModel: ContentsListData) {
            Snackbar.make(tappedView, "Replace with your own action tapped ${rowModel.contentName}", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

    }
