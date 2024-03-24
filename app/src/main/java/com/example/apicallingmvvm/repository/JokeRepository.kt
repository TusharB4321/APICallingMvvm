package com.example.apicallingmvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicallingmvvm.api.ApiInterface
import com.example.apicallingmvvm.model.Jokes

class JokeRepository(val apiInterface: ApiInterface) {

    private val mutableLiveData=MutableLiveData<Jokes>()

     val list: LiveData<Jokes>
        get()=mutableLiveData

    suspend fun getMemes(){
        val data=apiInterface.getJokes()

        if (data.body()!=null){
            mutableLiveData.postValue(data.body())
        }

    }


}