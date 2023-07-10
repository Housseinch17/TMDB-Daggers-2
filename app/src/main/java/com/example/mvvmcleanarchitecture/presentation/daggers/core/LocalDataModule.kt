package com.example.mvvmcleanarchitecture.presentation.daggers.core

import com.example.mvvmcleanarchitecture.data.db.ArtistDao
import com.example.mvvmcleanarchitecture.data.db.MovieDao
import com.example.mvvmcleanarchitecture.data.db.TvShowDao
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistLocalDataSourceImplementation
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieLocalDataSourceImplementation
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvLocalDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao):MovieLocalDataSource{
        return MovieLocalDataSourceImplementation(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistsLocalDataSource(artistDao: ArtistDao):ArtistLocalDataSource{
        return ArtistLocalDataSourceImplementation(artistDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao):TvLocalDataSource{
        return TvLocalDataSourceImplementation(tvShowDao)
    }

}