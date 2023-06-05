package com.bhagyawant.moviedb.data.mock

import android.content.Context
import com.bhagyawant.moviedb.common.Utils
import com.bhagyawant.moviedb.data.model.MovieDto
import com.bhagyawant.moviedb.domain.model.Movie
import com.bhagyawant.moviedb.domain.model.Ratings
import com.bhagyawant.moviedb.domain.repository.GetMoviesListRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class GetMoviesListRepositoryMockImpl @Inject constructor(private val context: Context, private val gson: Gson) : GetMoviesListRepository {

    var moviesJson : String? = ""

    override suspend fun getMovies(): List<Movie> {
        moviesJson = Utils.getJsonFromAssets(context,"movies.json")
        val moviesDtoList : List<MovieDto> = gson.fromJson(moviesJson, object : TypeToken<List<MovieDto>>(){}.type)
        return moviesDtoToMoviesMapper(moviesDtoList)
    }


    private fun moviesDtoToMoviesMapper(moviesDtoList : List<MovieDto>): List<Movie>{
        return moviesDtoList.map { movieDto ->
            Movie(
                Title = movieDto.Title,
                Year = movieDto.Year,
                Rated = movieDto.Rated,
                Released = movieDto.Released,
                Runtime = movieDto.Runtime,
                Genre = movieDto.Genre,
                Director = movieDto.Director,
                Writer = movieDto.Writer,
                Actors = movieDto.Actors,
                Plot = movieDto.Plot,
                Language = movieDto.Language,
                Country = movieDto.Country,
                Awards = movieDto.Awards,
                Poster = movieDto.Poster,
                Ratings = movieDto.Ratings.map { ratingDto ->
                    Ratings(ratingDto.Source, ratingDto.Value)
                } as ArrayList<Ratings>,
                Metascore = movieDto.Metascore,
                imdbRating = movieDto.imdbRating,
                imdbVotes = movieDto.imdbVotes,
                imdbID = movieDto.imdbID,
                Type = movieDto.Type,
                DVD = movieDto.DVD,
                BoxOffice = movieDto.BoxOffice,
                Production = movieDto.Production,
                Website = movieDto.Website,
                Response = movieDto.Response
            )
        }
    }

}