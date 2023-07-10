package com.example.mvvmcleanarchitecture.presentation.daggers.tvShow

import com.example.mvvmcleanarchitecture.domain.artist.GetArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.artist.UpdateArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.movie.GetMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.movie.UpdateMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.UpdateTvShowsUseCase
import com.example.mvvmcleanarchitecture.presentation.artists.ArtistsViewModelFactory
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModel
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModelFactory
import com.example.mvvmcleanarchitecture.presentation.tvshows.TvShowsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvModule() {
    @TvScope
    @Provides
    fun proviteTvViewModelFactory(
        getTvShowUseCase: GetTvShowUseCase,
        updateTvShowUseCase: UpdateTvShowsUseCase
    ):TvShowsViewModelFactory{
        return TvShowsViewModelFactory(
            getTvShowUseCase,
            updateTvShowUseCase)
    }

}