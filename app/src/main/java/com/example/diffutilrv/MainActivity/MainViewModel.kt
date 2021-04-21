package com.example.diffutilrv.MainActivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.diffutilrv.Bean.Employee
import com.example.diffutilrv.MainActivity.MainRepository

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val mEmployeeLiveData = MutableLiveData<List<Employee>>()
    private val mOnClickLiveData = MutableLiveData<String>()

    fun getEmployeeLiveData(): LiveData<List<Employee>> = mEmployeeLiveData
    fun getOnClickLiveData(): LiveData<String> = mOnClickLiveData

    init {
        getEmployeeList()
    }

    private fun getEmployeeList() {
        mEmployeeLiveData.value = mainRepository.getEmployeeList()
    }

    fun updateEmployeeListItemsByName() {
        mEmployeeLiveData.value = mainRepository.getEmployeeListSortedByName()
    }

    fun updateEmployeeListItemsByRole() {
        mEmployeeLiveData.value = mainRepository.getEmployeeListSortedByRole()
    }

    fun viewHolderOnClick(message: String) {
        mOnClickLiveData.value = message
    }
}