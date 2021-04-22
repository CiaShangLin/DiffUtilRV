package com.example.diffutilrv.ApiService

import com.example.diffutilrv.Bean.State
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

abstract class StateObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable) {
        onLoading(State.Loading(d))
    }

    override fun onNext(t: T) {
        onSuccess(State.Success(t))
    }

    override fun onError(e: Throwable) {
        onFail(State.Fail(e))
    }

    override fun onComplete() {

    }

    abstract fun onSuccess(it: State.Success<T>)
    abstract fun onFail(e: State.Fail)
    abstract fun onLoading(d: State.Loading)
}