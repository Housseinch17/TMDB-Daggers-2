package com.example.mvvmcleanarchitecture.domain.artist

import com.example.mvvmcleanarchitecture.data.model.artist.Artist

class UpdateArtistsUseCase(private val artistsRepository: ArtistRepository) {
    suspend fun execute(): List<Artist>?=artistsRepository.updateArtists()

}