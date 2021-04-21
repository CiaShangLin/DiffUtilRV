package com.example.diffutilrv.ApiService


import com.example.diffutilrv.Bean.CommentBeanItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun getCommentsPostId(@Url url: String): Observable<List<CommentBeanItem>>
}