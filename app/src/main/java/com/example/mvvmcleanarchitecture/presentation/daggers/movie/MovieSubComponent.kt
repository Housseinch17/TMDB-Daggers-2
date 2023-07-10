package com.example.mvvmcleanarchitecture.presentation.daggers.movie

import com.example.mvvmcleanarchitecture.presentation.movies.MoviesActivity
import dagger.Subcomponent


@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(moviesActivity: MoviesActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():MovieSubComponent
    }
}