package com.example.mvvmcleanarchitecture.presentation.daggers.artist

import com.example.mvvmcleanarchitecture.domain.artist.GetArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.artist.UpdateArtistsUseCase
import com.example.mvvmcleanarchitecture.presentation.artists.ArtistsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule() {
    @ArtistScope
    @Provides
    fun proviteArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ):ArtistsViewModelFactory{
        return ArtistsViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase)
    }

}