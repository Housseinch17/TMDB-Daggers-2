package com.example.mvvmcleanarchitecture.presentation.tvshows

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
import com.example.mvvmcleanarchitecture.databinding.ActivityMoviesBinding
import com.example.mvvmcleanarchitecture.databinding.ActivityTvShowsBinding
import com.example.mvvmcleanarchitecture.presentation.daggers.Injector
import com.example.mvvmcleanarchitecture.presentation.movies.MovieAdapter
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModel
import com.example.mvvmcleanarchitecture.presentation.movies.MoviesViewModelFactory
import javax.inject.Inject

class TvShowsActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowsViewModelFactory
    private lateinit var tvShowsViewModel : TvShowsViewModel
    private lateinit var adapter: TvShowsAdapter
    private lateinit var binding : ActivityTvShowsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_tv_shows)
        (application as Injector).createTvSubComponent()
            .inject(this)

        tvShowsViewModel= ViewModelProvider(this,factory)
            .get(TvShowsViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.recTvShows.layoutManager = LinearLayoutManager(this)
        adapter = TvShowsAdapter()
        binding.recTvShows.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows(){
        binding.progressTvShows.visibility = View.VISIBLE
        val responseLiveData = tvShowsViewModel.getTvShows()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressTvShows.visibility = View.GONE
            }
            else {
                binding.progressTvShows.visibility = View.GONE
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
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows(){
        binding.progressTvShows.visibility = View.VISIBLE
        val responseLiveData = tvShowsViewModel.updateTvShows()
        responseLiveData.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressTvShows.visibility = View.GONE
            }
            else
                binding.progressTvShows.visibility = View.GONE
        })
    }


}