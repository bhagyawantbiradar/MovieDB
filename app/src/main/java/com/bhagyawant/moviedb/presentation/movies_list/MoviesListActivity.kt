package com.bhagyawant.moviedb.presentation.movies_list

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bhagyawant.moviedb.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListActivity : AppCompatActivity() {
    private lateinit var movieListViewModel: MoviesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)
        movieListViewModel = ViewModelProvider(this)[MoviesListViewModel::class.java]
        findViewById<TextView>(R.id.tvHello).setOnClickListener {
            movieListViewModel.getMovies()
        }
    }

}