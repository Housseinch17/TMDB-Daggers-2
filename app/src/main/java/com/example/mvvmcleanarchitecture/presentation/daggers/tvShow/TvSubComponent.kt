package com.example.mvvmcleanarchitecture.presentation.daggers.tvShow

import com.example.mvvmcleanarchitecture.presentation.artists.ArtistsActivity
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesActivity
import com.example.mvvmcleanarchitecture.presentation.tvshows.TvShowsActivity
import dagger.Subcomponent


@TvScope
@Subcomponent(modules = [TvModule::class])
interface TvSubComponent {
    fun inject(tvShowsActivity: TvShowsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():TvSubComponent
    }
}