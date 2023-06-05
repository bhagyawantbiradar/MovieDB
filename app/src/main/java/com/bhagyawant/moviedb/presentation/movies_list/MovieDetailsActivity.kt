package com.bhagyawant.moviedb.presentation.movies_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bhagyawant.moviedb.R
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MovieDetailsActivity"
@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }
}