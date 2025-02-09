package com.example.mvvmcleanarchitecture.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitecture.domain.movie.GetMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.movie.UpdateMoviesUseCase
class MoviesViewModel(
    private val getMoviesUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {

    fun getMovies() = liveData{
        val movieList = getMoviesUseCase.execute()
        emit(movieList)
    }

    fun updateMovies() = liveData {
        val movieList = updateMoviesUseCase.execute()
        emit(movieList)
    }
}