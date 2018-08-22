package com.example.tatsuro.sportable

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View

class FacilitiesFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.facilities_fragment, container, false)
        return view
    }
    companion object {
        fun newInstance(): FacilitiesFragment {
            val fragment = FacilitiesFragment()
            //val args = Bundle()
            //fragment.setArguments(args)
            return fragment
        }
    }
}