package com.example.mvvmcleanarchitecture.presentation.daggers.core

import android.content.Context
import com.example.mvvmcleanarchitecture.presentation.daggers.artist.ArtistSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.movie.MovieSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.tvShow.TvSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class,TvSubComponent::class,ArtistSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }



}