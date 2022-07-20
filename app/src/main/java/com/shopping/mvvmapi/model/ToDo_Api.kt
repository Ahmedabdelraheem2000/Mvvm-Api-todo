package com.shopping.mvvmapi.model

data class ToDo_Api(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)