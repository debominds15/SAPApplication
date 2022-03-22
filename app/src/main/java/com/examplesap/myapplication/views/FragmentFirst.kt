package com.examplesap.myapplication.views

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.examplesap.myapplication.IUserFragmentState
import com.examplesap.myapplication.R

class FragmentFirst: Fragment(), View.OnClickListener{
    private lateinit var fragmentStateCallback: IUserFragmentState
    override fun onAttach(context: Context) {
        super.onAttach(context)

        fragmentStateCallback = activity as IUserFragmentState
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //super.onCreateView(inflater, container, savedInstanceState)
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        init(view)
        return view
    }

    private fun init(view: View){
        view.findViewById<View>(R.id.view_top_left).setOnClickListener(this)
        view.findViewById<View>(R.id.view_top_right).setOnClickListener(this)
        view.findViewById<View>(R.id.view_bottom_left).setOnClickListener(this)
        view.findViewById<View>(R.id.view_bottom_right).setOnClickListener(this)
        view.findViewById<View>(R.id.view_center).setOnClickListener(this)
    }

    companion object {
        fun getInstance(): FragmentFirst {
            return FragmentFirst()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id ?: 0){
            R.id.view_top_left -> {
                fragmentStateCallback.launchFragment(FragmentSecond(), Bundle(), "fargment_second")
            }
            R.id.view_top_right -> {
                fragmentStateCallback.launchFragment(FragmentSecond(), Bundle(), "fargment_second")
            }
            R.id.view_bottom_left -> {
                fragmentStateCallback.launchFragment(FragmentSecond(), Bundle(), "fargment_second")
            }
            R.id.view_bottom_right -> {
                fragmentStateCallback.launchFragment(FragmentSecond(), Bundle(), "fargment_second")
            }
            R.id.view_center -> {
                fragmentStateCallback.launchFragment(FragmentSecond(), Bundle(), "fargment_second")
            }
        }
    }
}