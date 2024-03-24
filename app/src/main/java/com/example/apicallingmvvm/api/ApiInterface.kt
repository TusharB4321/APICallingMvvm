package com.example.apicallingmvvm.api

import com.example.apicallingmvvm.model.Jokes
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface ApiInterface {

    @GET("/get_memes")
    suspend fun getJokes(): Response<Jokes>
}