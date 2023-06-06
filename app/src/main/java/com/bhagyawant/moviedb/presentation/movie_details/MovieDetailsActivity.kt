package com.bhagyawant.moviedb.presentation.movie_details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhagyawant.moviedb.R
import com.bhagyawant.moviedb.common.SharedData
import com.bhagyawant.moviedb.common.toListOfStrings
import com.bhagyawant.moviedb.databinding.ActivityMovieDetailsBinding
import com.bhagyawant.moviedb.domain.model.Cast
import com.bhagyawant.moviedb.domain.model.Movie
import com.bhagyawant.moviedb.presentation.movie_details.adapter.CastAdapter
import com.bhagyawant.moviedb.presentation.movie_details.adapter.GenreAdapter
import dagger.hilt.android.AndroidEntryPoint

private const val TAG = "MovieDetailsActivity"

@AndroidEntryPoint
class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var movieDetailsViewModel: MovieDetailsViewModel
    private lateinit var binding: ActivityMovieDetailsBinding
    private lateinit var movie: Movie
    private lateinit var genreList : List<String>
    private val castList = listOf(
        Cast(character = "Neo", imageUrl = "https://encrypted-tbn0.gstatic.com/licensed-image?q=tbn:ANd9GcSZG4xRtQTawU7GQ75VQ9Fv0gUgU7PnGutWGFYTPEJWAWEJYlJh_rkEGhkKcqGkdfzXmWhO9tVMTl5r6aQ", name = "Keanu Reeves"),
        Cast(character = "Morpheus", imageUrl = "https://imaging.broadway.com/images/regular-43/w735/114207-15.jpg", name = "Laurence Fishburne"),
        Cast(character = "Trinity", imageUrl = "https://encrypted-tbn2.gstatic.com/licensed-image?q=tbn:ANd9GcTy_KieqMn9n7NmRiycEOvfqBji0X3ENxtRD9imWwgCj1JcdnfmeEaZuR9XDaGt2W0dRaPmv7ddS6cmhJo", name = "Trinity")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        movieDetailsViewModel = ViewModelProvider(this)[MovieDetailsViewModel::class.java]
        binding = DataBindingUtil.setContentView<ActivityMovieDetailsBinding>(this, R.layout.activity_movie_details)
            .apply {
                lifecycleOwner = this@MovieDetailsActivity
                movieDetailViewModel = movieDetailsViewModel
            }

        SharedData.movie?.let {
            movie = it
        }
        movieDetailsViewModel.updateMovie(movie)
        setGenre()
        setCast()

        movieDetailsViewModel.isClickedLiveData.observe(this){isClicked->
            if(isClicked){
                Toast.makeText(this,"Coming soon...",Toast.LENGTH_SHORT).show()
                movieDetailsViewModel.updateClick(false)
            }
        }

    }

    private fun setCast() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = CastAdapter(castList)

        with(binding){
            rvCast.layoutManager = layoutManager
            rvCast.adapter = adapter
        }
    }

    private fun setGenre() {
        movie.Genre?.let {
            genreList = it.toListOfStrings()
        }
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = GenreAdapter(genreList)

        with(binding){
            rvGenre.layoutManager = layoutManager
            rvGenre.adapter = adapter
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        SharedData.movie = null
    }
}