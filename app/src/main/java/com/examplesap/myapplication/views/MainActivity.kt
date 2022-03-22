package com.examplesap.myapplication.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.examplesap.myapplication.IUserCallback
import com.examplesap.myapplication.IUserFragmentState
import com.examplesap.myapplication.R

class MainActivity : AppCompatActivity(), IUserFragmentState, IUserCallback {

    private lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        viewModel.getUsers()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, FragmentFirst.getInstance(), "first_fragment")
            .addToBackStack(null)
            .commit()
        
    }

    override fun launchFragment(fragment: Fragment, bundle: Bundle, tag: String) {
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_container, fragment, tag)
            .addToBackStack(null)
            .commit()
    }

    override fun getViewModel(): UserViewModel {
        return viewModel
    }
}