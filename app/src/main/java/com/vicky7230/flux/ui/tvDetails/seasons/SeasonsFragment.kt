package com.vicky7230.flux.ui.tvDetails.seasons


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vicky7230.flux.R


/**
 * A simple [Fragment] subclass.
 */
class SeasonsFragment : Fragment() {

    companion object {
        fun newInstance() = SeasonsFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seasons, container, false)
    }

}// Required empty public constructor