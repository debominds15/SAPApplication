package com.examplesap.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

interface IUserFragmentState {
    fun launchFragment(fragment: Fragment, bundle: Bundle, tag: String)
}