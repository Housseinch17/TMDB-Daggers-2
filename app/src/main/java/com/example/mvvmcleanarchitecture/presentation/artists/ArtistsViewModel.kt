package com.example.mvvmcleanarchitecture.presentation.artists

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mvvmcleanarchitecture.domain.artist.GetArtistsUseCase
import com.example.mvvmcleanarchitecture.domain.artist.UpdateArtistsUseCase

class ArtistsViewModel(
    private val getArtistsUseCase: GetArtistsUseCase,
    private val updateArtistsUseCase: UpdateArtistsUseCase
) : ViewModel() {

    fun getArtists() = liveData{
        val artistsList = getArtistsUseCase.execute()
        emit(artistsList)
    }

    fun updateArtists() = liveData {
        val artistsList = updateArtistsUseCase.execute()
        emit(artistsList)
    }
}