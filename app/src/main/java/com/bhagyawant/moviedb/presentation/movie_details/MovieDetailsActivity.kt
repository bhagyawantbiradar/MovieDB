package com.bhagyawant.moviedb.presentation.movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bhagyawant.moviedb.R
import com.bhagyawant.moviedb.databinding.ActivityMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MovieDetailsActivity"

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var movieDetailsViewModel: MovieDetailsViewModel
    private lateinit var binding : ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie_details)
        movieDetailsViewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
    }
}