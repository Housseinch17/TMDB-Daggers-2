package com.example.mvvmcleanarchitecture.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcleanarchitecture.domain.artist.GetArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.artist.UpdateArtistsUseCase

class ArtistsViewModelFactory(
    private val getArtistsUseCase: GetArtistsUseCase ,
    private val updateArtistsUseCase: UpdateArtistsUseCase
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArtistsViewModel(getArtistsUseCase,updateArtistsUseCase) as T
    }
}