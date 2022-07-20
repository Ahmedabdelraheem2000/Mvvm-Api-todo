package com.shopping.mvvmapi.server

import com.shopping.mvvmapi.model.ToDo_Api
import retrofit2.Response
import retrofit2.http.GET

interface Todo_Responce {
    @GET("/todos")
    suspend fun getTodos() : Response<List<ToDo_Api>>
}