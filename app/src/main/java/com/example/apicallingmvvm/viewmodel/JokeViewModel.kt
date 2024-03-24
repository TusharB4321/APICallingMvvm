package com.example.apicallingmvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicallingmvvm.model.Jokes
import com.example.apicallingmvvm.repository.JokeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class JokeViewModel(val repository: JokeRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getMemes()
        }
    }
    val list:LiveData<Jokes>
    get() = repository.list



}