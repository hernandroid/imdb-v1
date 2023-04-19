package com.globant.data.repository.source.remote

import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import kotlinx.coroutines.flow.Flow

interface RemoteMovieDataSource {

    fun getTopRatedMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Flow<Page<List<Movie>>>

    fun getPopularMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Flow<Page<List<Movie>>>

    fun getMovieRecommendations(
        movieId: Int,
        language: String?,
        page: Int?,
    ): Flow<Page<List<Movie>>>

    fun getMovieDetails(
        movieId: Int,
        language: String?,
        appendToResponse: String?,
    ): Flow<Movie>

}