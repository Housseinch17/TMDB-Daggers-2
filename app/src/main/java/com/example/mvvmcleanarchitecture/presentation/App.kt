package com.example.mvvmcleanarchitecture.presentation

import android.app.Application
import com.example.mvvmcleanarchitecture.Constants.Constants
import com.example.mvvmcleanarchitecture.presentation.daggers.Injector
import com.example.mvvmcleanarchitecture.presentation.daggers.artist.ArtistSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.core.*
import com.example.mvvmcleanarchitecture.presentation.daggers.movie.MovieSubComponent
import com.example.mvvmcleanarchitecture.presentation.daggers.tvShow.TvSubComponent
import dagger.Component

class App : Application(),Injector {
    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(Constants.BASE_URL))
            .remoteDataModule(RemoteDataModule(Constants.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvSubComponent(): TvSubComponent {
        return appComponent.tvSubComponent().create()
    }
}