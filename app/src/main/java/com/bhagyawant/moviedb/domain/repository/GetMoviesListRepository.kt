package com.bhagyawant.moviedb.domain.repository

import com.bhagyawant.moviedb.domain.model.Movie


interface GetMoviesListRepository {
    suspend fun getMovies() : List<Movie>
}