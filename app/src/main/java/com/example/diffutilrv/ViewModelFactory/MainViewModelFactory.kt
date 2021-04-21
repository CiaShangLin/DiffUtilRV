package com.example.diffutilrv.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diffutilrv.MainActivity.MainRepository
import com.example.diffutilrv.MainActivity.MainViewModel

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(MainRepository()) as T
    }
}