package com.example.apicallingmvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.apicallingmvvm.repository.JokeRepository

class JokeViewModelFactory(val repository: JokeRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return JokeViewModel(repository) as T
    }
}