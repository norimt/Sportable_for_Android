package com.example.tatsuro.sportable

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View

class CommunitiesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.communities_fragment, container, false)
        return view
    }
    companion object {
        fun newInstance(): CommunitiesFragment {
            val fragment = CommunitiesFragment()
            //val args = Bundle()
            //fragment.setArguments(args)
            return fragment
        }
    }
}