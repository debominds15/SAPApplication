package com.examplesap.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.examplesap.myapplication.views.UserViewModel

interface IUserCallback {
    fun getViewModel(): UserViewModel
}