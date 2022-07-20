package com.shopping.mvvmapi.server

import com.google.gson.Gson
import com.shopping.mvvmapi.model.ToDo_Api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Todos_Api_Instence {


    val api:Todo_Responce by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Todo_Responce::class.java)

    }
}