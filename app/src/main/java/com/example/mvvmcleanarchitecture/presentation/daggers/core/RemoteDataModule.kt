package com.example.mvvmcleanarchitecture.presentation.daggers.core

import com.example.mvvmcleanarchitecture.data.api.TMDBService
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistRemoteSourceImplementation
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieRemoteDataSourceImplementation
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvRemoteSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey:String) {

    @Singleton
    @Provides
    fun provideMovieRemoteDataSource(tmdbService: TMDBService):MovieRemoteDataSource{
        return MovieRemoteDataSourceImplementation(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideArtistRemoteDataSource(tmdbService: TMDBService):ArtistRemoteDataSource{
        return ArtistRemoteSourceImplementation(
            tmdbService,apiKey
        )
    }

    @Singleton
    @Provides
    fun provideTvShowRemoteDataSource(tmdbService: TMDBService):TvRemoteDataSource{
        return TvRemoteSourceImplementation(
            tmdbService,apiKey
        )
    }
}