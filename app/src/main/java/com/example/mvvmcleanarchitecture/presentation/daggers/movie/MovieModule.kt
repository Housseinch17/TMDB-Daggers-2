package com.example.mvvmcleanarchitecture.presentation.daggers.movie

import com.example.mvvmcleanarchitecture.domain.artist.GetArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.artist.UpdateArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.movie.GetMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.movie.UpdateMoviesUseCase
import com.example.mvvmcleanarchitecture.presentation.artists.ArtistsViewModelFactory
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModel
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule() {

    @MovieScope
    @Provides
    fun proviteMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ):MoviesViewModelFactory{
        return MoviesViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase)
    }

}