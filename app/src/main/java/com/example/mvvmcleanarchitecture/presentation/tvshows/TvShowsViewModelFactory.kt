package com.example.mvvmcleanarchitecture.presentation.tvshows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitecture.domain.movie.GetMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.movie.UpdateMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.UpdateTvShowsUseCase

class TvShowsViewModelFactory(
    private val getTvShowUseCase: GetTvShowUseCase ,
    private val updateTvShowsUseCase: UpdateTvShowsUseCase
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowsViewModel(getTvShowUseCase,updateTvShowsUseCase) as T
    }
}