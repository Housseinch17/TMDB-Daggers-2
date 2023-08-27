package com.example.mvvmcleanarchitecture.presentation.artists

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmcleanarchitecture.R
import com.example.mvvmcleanarchitecture.databinding.ActivityArtistsBinding
import com.example.mvvmcleanarchitecture.databinding.ActivityMoviesBinding
import com.example.mvvmcleanarchitecture.presentation.daggers.Injector
import com.example.mvvmcleanarchitecture.presentation.movies.MovieAdapter
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModel
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModelFactory
import javax.inject.Inject

class ArtistsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistsViewModelFactory
    private lateinit var artistsViewModel : ArtistsViewModel
    private lateinit var adapter: ArtistsAdapter
    private lateinit var binding : ActivityArtistsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_artists)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        artistsViewModel= ViewModelProvider(this,factory)
            .get(ArtistsViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.recArtists.layoutManager = LinearLayoutManager(this)
        adapter = ArtistsAdapter()
        binding.recArtists.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists(){
        binding.progressArtists.visibility = View.VISIBLE
        val responseLiveData = artistsViewModel.getArtists()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressArtists.visibility = View.GONE
            }
            else {
                binding.progressArtists.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.update,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update ->{
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists(){
        binding.progressArtists.visibility = View.VISIBLE
        val responseLiveData = artistsViewModel.updateArtists()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressArtists.visibility = View.GONE
            }
            else
                binding.progressArtists.visibility = View.GONE
        })
    }


}