package com.bhagyawant.moviedb.presentation.movies_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhagyawant.moviedb.common.Resource
import com.bhagyawant.moviedb.domain.GetMoviesListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

private const val TAG = "MoviesListViewModel"
@HiltViewModel
class MoviesListViewModel @Inject constructor(val getMoviesListUseCase: GetMoviesListUseCase) :
    ViewModel() {



    internal fun getMovies() {
        getMoviesListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    Log.d(TAG, "getMovies: Title ${result.data!![0].Title}")
                }
                is Resource.Error -> {
                    Log.e(TAG, "getMovies: ${result.message}")
                }
                is Resource.Loading -> {
                    Log.d(TAG, "getMovies: Loading...")
                }
            }
        }.launchIn(viewModelScope)
    }

}