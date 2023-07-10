package com.example.mvvmcleanarchitecture.presentation.daggers.core

import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.artist.ArtistRepositoryImplementation
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.movie.MovieRepositoryImplementation
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvCacheDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvLocalDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvRemoteDataSource
import com.example.mvvmcleanarchitecture.data.repository.tvshow.TvRepositoryImplementation
import com.example.mvvmcleanarchitecture.domain.artist.ArtistRepository
import com.example.mvvmcleanarchitecture.domain.movie.MovieRepository
import com.example.mvvmcleanarchitecture.domain.tvshow.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ) : MovieRepository{

        return MovieRepositoryImplementation(
            movieRemoteDataSource,
            movieLocalDataSource,
            movieCacheDataSource
        )

    }


    @Singleton
    @Provides
    fun provideTvRepository(
        tvRemoteDataSource: TvRemoteDataSource,
        tvLocalDataSource: TvLocalDataSource,
        tvCacheDataSource: TvCacheDataSource
    ) : TvShowRepository{

        return TvRepositoryImplementation(
            tvRemoteDataSource,
            tvLocalDataSource,
            tvCacheDataSource
        )

    }



    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ) : ArtistRepository{

        return ArtistRepositoryImplementation(
            artistRemoteDataSource,
            artistLocalDataSource,
            artistCacheDataSource
        )

    }
}