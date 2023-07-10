package com.example.mvvmcleanarchitecture.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.databinding.ActivityMoviesBinding
import com.example.mvvmcleanarchitecture.presentation.daggers.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {
    @Inject
    lateinit var binding : ActivityMoviesBinding
    lateinit var factory:MoviesViewModelFactory
    private lateinit var movieViewModel : MoviesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movies)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel=ViewModelProvider(this,factory)
            .get(MoviesViewModel::class.java)
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            Log.i("MYTAG",it.toString())
        })
    }
}