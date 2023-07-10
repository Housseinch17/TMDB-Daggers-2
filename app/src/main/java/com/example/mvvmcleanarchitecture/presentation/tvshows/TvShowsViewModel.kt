package com.example.mvvmcleanarchitecture.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitecture.domain.movie.GetMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.movie.UpdateMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.UpdateTvShowsUseCase

class TvShowsViewModel(
    private val getTvShowsUseCase: GetTvShowUseCase,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
) : ViewModel() {

    fun getTvShows() = liveData{
        val tvShowsList = getTvShowsUseCase.execute()
        emit(tvShowsList)
    }

    fun updateTvShows() = liveData {
        val tvShowsList = updateTvShowsUseCase.execute()
        emit(tvShowsList)
    }
}