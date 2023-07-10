package com.example.mvvmcleanarchitecture.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.databinding.ActivityMainBinding
import com.example.mvvmcleanarchitecture.presentation.artists.ArtistsActivity
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesActivity
import com.example.mvvmcleanarchitecture.presentation.tvshows.TvShowsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.btnMovies.setOnClickListener{
            val intent=Intent(this,MoviesActivity::class.java)
            startActivity(intent)
        }

        binding.btnArtists.setOnClickListener{
            val intent=Intent(this,ArtistsActivity::class.java)
            startActivity(intent)
        }

        binding.btnTvShows.setOnClickListener{
            val intent=Intent(this,TvShowsActivity::class.java)
            startActivity(intent)
        }


    }
}