package com.bhagyawant.moviedb.presentation.movies_list

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bhagyawant.moviedb.R
import com.bhagyawant.moviedb.databinding.ActivityMoviesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesListActivity : AppCompatActivity() {
    private lateinit var movieListViewModel: MoviesListViewModel
    private lateinit var binding : ActivityMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieListViewModel = ViewModelProvider(this)[MoviesListViewModel::class.java]

        binding = DataBindingUtil.setContentView<ActivityMoviesListBinding?>(this,R.layout.activity_movies_list).apply {
            lifecycleOwner = this@MoviesListActivity
            viewmodel = movieListViewModel
        }


    }

}