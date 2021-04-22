package com.example.diffutilrv.MainActivity

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.diffutilrv.Bean.CommentBeanItem
import com.example.diffutilrv.Bean.Employee
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val mCompositeDisposable = CompositeDisposable()
    private val mEmployeeLiveData = MutableLiveData<List<Employee>>()
    private val mCommentLiveData = MutableLiveData<List<CommentBeanItem>>()
    private val mOnClickLiveData = MutableLiveData<String>()

    fun getEmployeeLiveData(): LiveData<List<Employee>> = mEmployeeLiveData
    fun getCommentLiveData(): LiveData<List<CommentBeanItem>> = mCommentLiveData
    fun getOnClickLiveData(): LiveData<String> = mOnClickLiveData

    init {
        getEmployeeList()
    }

    //預設資料
    private fun getEmployeeList() {
        mEmployeeLiveData.value = mainRepository.getEmployeeList()
    }

    //依照名字排序
    fun updateEmployeeListItemsByName() {
        mEmployeeLiveData.value = mainRepository.getEmployeeListSortedByName()
    }

    //依照Role排序
    fun updateEmployeeListItemsByRole() {
        mEmployeeLiveData.value = mainRepository.getEmployeeListSortedByRole()
    }

    //測試ViewHolder的Callback
    fun viewHolderOnClick(message: String) {
        mOnClickLiveData.value = message
    }

    //來自網路的資料
    fun getCommentPostIdApi(postId: Int) {
        mainRepository.getCommentPostIdApi(postId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<List<CommentBeanItem>> {
                override fun onSubscribe(d: Disposable?) {
                    mCompositeDisposable.add(d)
                }

                override fun onNext(it: List<CommentBeanItem>) {
                    mCommentLiveData.value = it
                }

                override fun onError(e: Throwable?) {
                    e?.printStackTrace()
                }

                override fun onComplete() {

                }
            })
    }

    //當ViewModel被清除時順便把沒做完的Dispose停止
    override fun onCleared() {
        super.onCleared()
        mCompositeDisposable.dispose()
    }
}