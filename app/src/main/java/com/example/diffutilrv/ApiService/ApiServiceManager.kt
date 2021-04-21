package com.example.diffutilrv.ApiService

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiServiceManager {
    private val mRetrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com.tw/")
        .addConverterFactory(MoshiConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val apiService by lazy { mRetrofit.create(ApiService::class.java) }
}