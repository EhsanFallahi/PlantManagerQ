package com.fallahiehsan.plantmanager.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import com.fallahiehsan.plantmanager.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {

        Log.i("plantResponse"," onCreateView")
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.plants.observe(viewLifecycleOwner, Observer {
                plants->tv_auto_complete.setAdapter(ArrayAdapter(context!!,R.layout.support_simple_spinner_dropdown_item,plants))
        })

        return inflater.inflate(R.layout.main_fragment, container, false)
    }



}