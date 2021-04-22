package com.example.diffutilrv.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.diffutilrv.MainActivity.MainRepository
import com.example.diffutilrv.MainActivity.MainViewModel

/**
 * ViewModel需要額外的建構值就需要自定義ViewModelFactory
 * 也是可以使用Koin來解決這個問題
 */
class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(MainRepository()) as T
    }
}