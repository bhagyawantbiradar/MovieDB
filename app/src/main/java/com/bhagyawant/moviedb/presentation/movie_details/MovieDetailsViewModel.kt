package com.bhagyawant.moviedb.presentation.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bhagyawant.moviedb.domain.model.Movie
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MovieDetailsViewModel @Inject constructor() : ViewModel() {

    private val movieObject = MutableLiveData<Movie>()
    val movieLiveData : LiveData<Movie>
    get() = movieObject


}