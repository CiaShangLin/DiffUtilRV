package com.example.diffutilrv.Bean

import io.reactivex.rxjava3.disposables.Disposable

sealed class State {
    class Loading(val disposable: Disposable) : State()
    class Success<T>(val data: T) : State()
    class Fail(val exception: Throwable) : State()
}