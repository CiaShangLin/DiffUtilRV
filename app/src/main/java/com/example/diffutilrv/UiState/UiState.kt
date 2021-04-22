package com.example.diffutilrv.UiState

import io.reactivex.rxjava3.disposables.Disposable

sealed class UiState<out T> {
    class Loading(val disposable: Disposable) : UiState<Nothing>()
    class Success<T>(val data: T) : UiState<T>()
    class Fail(val exception: Throwable) : UiState<Nothing>()
}