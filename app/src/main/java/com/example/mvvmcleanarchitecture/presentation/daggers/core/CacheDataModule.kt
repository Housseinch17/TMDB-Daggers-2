package com.example.mvvmcleanarchitecture.presentation.daggers.core

import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistCacheDataSourceImplementation
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieCacheDataSourceImplementation
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvCacheDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource():MovieCacheDataSource{
        return MovieCacheDataSourceImplementation()
    }


    @Singleton
    @Provides
    fun provideArtistCacheDataSource():ArtistCacheDataSource{
        return ArtistCacheDataSourceImplementation()
    }


    @Singleton
    @Provides
    fun provideTvShowCacheDataSource():TvCacheDataSource{
        return TvCacheDataSourceImplementation()
    }
}