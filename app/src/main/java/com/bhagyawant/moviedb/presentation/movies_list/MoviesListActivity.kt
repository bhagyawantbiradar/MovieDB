package com.bhagyawant.moviedb.presentation.movies_list

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhagyawant.moviedb.R
import com.bhagyawant.moviedb.common.SharedData
import com.bhagyawant.moviedb.databinding.ActivityMoviesListBinding
import com.bhagyawant.moviedb.domain.model.Movie
import com.bhagyawant.moviedb.presentation.movie_details.MovieDetailsActivity
import com.bhagyawant.moviedb.presentation.movie_details.adapter.CastAdapter
import com.bhagyawant.moviedb.presentation.movies_list.adapter.MovieAdapter
import com.bhagyawant.moviedb.presentation.movies_list.adapter.OnMovieClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListActivity : AppCompatActivity(), OnMovieClickListener {
    private lateinit var movieListViewModel: MoviesListViewModel
    private lateinit var binding: ActivityMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieListViewModel = ViewModelProvider(this)[MoviesListViewModel::class.java]

        binding = DataBindingUtil.setContentView<ActivityMoviesListBinding?>(
            this,
            R.layout.activity_movies_list
        ).apply {
            lifecycleOwner = this@MoviesListActivity
            viewmodel = movieListViewModel
        }
        movieListViewModel.getMovies()
        setMoviesList()

    }

    private fun setMoviesList() {
        val layoutManager = LinearLayoutManager(this)
        val adapter = movieListViewModel.movieListLiveData.value?.let {
            MovieAdapter(
                it,
                this@MoviesListActivity
            )
        }
        with(binding) {
            rvMovies.layoutManager = layoutManager
            rvMovies.adapter = adapter
        }
    }

    override fun onMovieClick(movie: Movie) {
        SharedData.movie = movie
        startActivity(Intent(this, MovieDetailsActivity::class.java))
    }

}