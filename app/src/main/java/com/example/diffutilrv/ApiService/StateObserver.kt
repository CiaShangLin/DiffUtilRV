package com.example.diffutilrv.ApiService

import com.example.diffutilrv.UiState.UiState
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

abstract class StateObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable) {
        onLoading(UiState.Loading(d))
    }

    override fun onNext(t: T) {
        onSuccess(UiState.Success(t))
    }

    override fun onError(e: Throwable) {
        onFail(UiState.Fail(e))
    }

    override fun onComplete() {

    }

    abstract fun onSuccess(it: UiState.Success<T>)
    abstract fun onFail(e: UiState.Fail)
    abstract fun onLoading(d: UiState.Loading)
}