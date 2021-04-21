package com.example.diffutilrv.Bean

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CommentBeanItem(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)