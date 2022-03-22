package com.examplesap.myapplication.views

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.examplesap.myapplication.IUserCallback
import com.examplesap.myapplication.IUserFragmentState
import com.examplesap.myapplication.R
import com.examplesap.myapplication.data.User

class UserAdapter(val list: List<User>, private val context: Activity) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {
    private var callback: IUserFragmentState = context as IUserFragmentState
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view : View = View.inflate(context, R.layout.item_holder, parent)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position], context, callback)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view){
        val imgUser = view.findViewById<ImageView>(R.id.img_user)
        val tvUser = view.findViewById<TextView>(R.id.tv_user)
        fun bind(user: User, context: Context, callback: IUserFragmentState) {
            tvUser.text = user.name
            Glide.with(context)
                .load(user.imageUrl)
                .into(imgUser)

            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("user_name", user.name)
                bundle.putString("image_url", user.imageUrl)
                callback.launchFragment(FragmentThird.getInstance(), bundle, "detail_fragment")
            }

        }

    }
}