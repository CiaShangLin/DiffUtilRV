package com.example.diffutilrv.MainActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.diffutilrv.Bean.CommentBeanItem
import com.example.diffutilrv.Bean.Employee
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

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

    fun getCommentPostIdApi(postId: Int) {
        mainRepository.getCommentPostIdApi(postId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object: Observer<List<CommentBeanItem>> {
                override fun onSubscribe(d: Disposable?) {

                }

                override fun onNext(t: List<CommentBeanItem>?) {
                    Log.d("DEBUG",t.toString())
                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }

                override fun onComplete() {

                }
            })
    }
}