package com.example.mvvmcleanarchitecture.presentation.daggers.core

import com.example.mvvmcleanarchitecture.presentation.daggers.artist.ArtistSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.movie.MovieSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.tvShow.TvSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
DataBaseModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class
])
interface AppComponent {

    fun movieSubComponent():MovieSubComponent.Factory
    fun tvSubComponent():TvSubComponent.Factory
    fun artistSubComponent():ArtistSubComponent.Factory

}