package com.examplesap.myapplication.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.examplesap.myapplication.IUserCallback
import com.examplesap.myapplication.R

class FragmentSecond : Fragment() {
    private lateinit var callback: IUserCallback
    private lateinit var viewModel: UserViewModel
    override fun onAttach(context: Context) {
        super.onAttach(context)
        callback = activity as IUserCallback
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_fragment, container, false)
        init(view)
        return  view
    }

    private fun init(v: View){
        viewModel = callback.getViewModel()
        val rv = v.findViewById<RecyclerView>(R.id.rv_items)
        //rv.layoutManager = RecyclerView.LayoutManag
        viewModel.usersData.observe(viewLifecycleOwner,
        Observer {
            rv.adapter = (activity as MainActivity)?.let { it1 -> UserAdapter(it, it1) }
        })


    }
}