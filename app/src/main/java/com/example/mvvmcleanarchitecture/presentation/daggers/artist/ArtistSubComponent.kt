package com.example.mvvmcleanarchitecture.presentation.daggers.artist

import com.example.mvvmcleanarchitecture.presentation.artists.ArtistsActivity
import dagger.Subcomponent


@ArtistScope
@Subcomponent(modules = [ArtistModule::class])
interface ArtistSubComponent {
    fun inject(artistsActivity: ArtistsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():ArtistSubComponent
    }
}