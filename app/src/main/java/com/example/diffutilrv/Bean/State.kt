package com.example.diffutilrv.Bean

import io.reactivex.rxjava3.disposables.Disposable

sealed class State<out T> {
    class Loading(val disposable: Disposable) : State<Nothing>()
    class Success<T>(val data: T) : State<T>()
    class Fail(val exception: Throwable) : State<Nothing>()
}