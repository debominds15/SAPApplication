package com.examplesap.myapplication.views

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.examplesap.myapplication.data.User
import com.examplesap.myapplication.repo.UserRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    val repo = UserRepo()
    val usersData = MutableLiveData<List<User>>()
    fun getUsers() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val users = repo.getUsers()
                usersData.postValue(users)
            } catch (e: Exception) {
                usersData.postValue(listOf())
            }
        }
    }
}