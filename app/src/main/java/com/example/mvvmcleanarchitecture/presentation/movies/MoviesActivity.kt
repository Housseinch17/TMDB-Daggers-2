package com.example.mvvmcleanarchitecture.presentation.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
import com.example.mvvmcleanarchitecture.databinding.ActivityMoviesBinding
import com.example.mvvmcleanarchitecture.presentation.daggers.Injector
import javax.inject.Inject

class MoviesActivity : AppCompatActivity() {
    @Inject
    lateinit var factory:MoviesViewModelFactory
    lateinit var binding : ActivityMoviesBinding
    private lateinit var movieViewModel : MoviesViewModel
    private lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_movies)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        movieViewModel=ViewModelProvider(this,factory)
            .get(MoviesViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.recMovies.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recMovies.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies(){
        binding.progressMovies.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressMovies.visibility = View.GONE
            }
            else {
                binding.progressMovies.visibility = View.GONE
                Toast.makeText(applicationContext,"No data available",Toast.LENGTH_LONG).show()
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
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies(){
        binding.progressMovies.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.updateMovies()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressMovies.visibility = View.GONE
            }
            else
                binding.progressMovies.visibility = View.GONE
        })
    }


}