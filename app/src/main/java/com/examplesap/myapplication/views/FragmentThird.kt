package com.examplesap.myapplication.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.examplesap.myapplication.R
import com.examplesap.myapplication.data.User

class FragmentThird : Fragment() {
    private lateinit var user: User
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.third_fragment, container, false)
        init(view)
        return view
    }
    private fun init(v: View){
        val tvName = v.findViewById<TextView>(R.id.tv_detail)
        val image = v.findViewById<ImageView>(R.id.img_detail)
        tvName.text = user.name
        Glide.with(this)
            .load(user.imageUrl)
            .into(image)

    }

    companion object {
        fun getInstance(): FragmentThird {

            return FragmentThird()
        }
    }
}