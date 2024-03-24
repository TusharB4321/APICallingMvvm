package com.example.apicallingmvvm.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {

    const val BASE_URL="https://api.imgflip.com"

    fun getInterface():Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}