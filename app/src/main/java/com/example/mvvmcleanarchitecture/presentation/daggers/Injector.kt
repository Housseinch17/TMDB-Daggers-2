package com.example.mvvmcleanarchitecture.presentation.daggers

import com.example.mvvmcleanarchitecture.presentation.daggers.artist.ArtistSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.movie.MovieSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.tvShow.TvSubComponent

interface Injector {
    fun createMovieSubComponent():MovieSubComponent
    fun createArtistSubComponent():ArtistSubComponent
    fun createTvSubComponent():TvSubComponent
}