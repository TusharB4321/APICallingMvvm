package com.example.apicallingmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import com.example.apicallingmvvm.api.ApiInterface
import com.example.apicallingmvvm.databinding.ActivityMainBinding
import com.example.apicallingmvvm.repository.JokeRepository
import com.example.apicallingmvvm.utils.Constants
import com.example.apicallingmvvm.viewmodel.JokeViewModel
import com.example.apicallingmvvm.viewmodel.JokeViewModelFactory
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: JokeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val apiInterface=Constants.getInterface().create(ApiInterface::class.java)
        val repository=JokeRepository(apiInterface)
        viewModel=ViewModelProvider(this,JokeViewModelFactory(repository)).get(JokeViewModel::class.java)

        lifecycleScope.launch {
            viewModel.list.observe(this@MainActivity) {

                it.data.memes.iterator().forEach {meme->
                    Log.d("Tush", "onCreate: ${meme.toString()}")
                }
            }
        }
    }
}