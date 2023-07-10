package com.example.mvvmcleanarchitecture.presentation.daggers.core

import com.example.mvvmcleanarchitecture.domain.artist.ArtistRepository
import com.example.mvvmcleanarchitecture.domain.artist.GetArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.artist.UpdateArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.movie.GetMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.movie.MovieRepository
import com.example.mvvmcleanarchitecture.domain.movie.UpdateMoviesUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.GetTvShowUseCase
import com.example.mvvmcleanarchitecture.domain.tvshow.TvShowRepository
import com.example.mvvmcleanarchitecture.domain.tvshow.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

    @Provides
    fun provideGetMovieUseCase(movieRepository : MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMovieUseCase(movieRepository: MovieRepository): UpdateMoviesUseCase{
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistsUseCase(artistRepository: ArtistRepository):GetArtistsUseCase{
        return GetArtistsUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCase(artistsRepository: ArtistRepository):UpdateArtistsUseCase{
        return UpdateArtistsUseCase(artistsRepository)
    }

    @Provides
    fun provideGetTvShowUseCase(tvShowRepository: TvShowRepository):GetTvShowUseCase{
        return GetTvShowUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowUseCase(tvShowRepository: TvShowRepository):UpdateTvShowsUseCase{
        return UpdateTvShowsUseCase(tvShowRepository)
    }
}