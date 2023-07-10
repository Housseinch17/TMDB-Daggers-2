package com.example.mvvmcleanarchitecture.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.databinding.ActivityArtistsBinding

class ArtistsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artists)
    }
}