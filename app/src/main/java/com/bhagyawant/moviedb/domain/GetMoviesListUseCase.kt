package com.bhagyawant.moviedb.domain

import com.bhagyawant.moviedb.common.Resource
import com.bhagyawant.moviedb.domain.model.Movie
import com.bhagyawant.moviedb.domain.repository.GetMoviesListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMoviesListUseCase @Inject constructor(private val getMoviesListRepository: GetMoviesListRepository) {

    operator fun invoke() : Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val result = getMoviesListRepository.getMovies()
            emit(Resource.Success(result))
        }catch (e : java.lang.Exception){
            emit(Resource.Error(message = "Exception"))
        }
    }

}