package com.globant.data.repository.impl

import com.globant.data.repository.source.remote.RemoteMovieDataSource
import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteMovieDataSource: RemoteMovieDataSource
) : MovieRepository {

    override fun getTopRatedMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Flow<Page<List<Movie>>> =
        remoteMovieDataSource.getTopRatedMovies(
            language,
            page,
            region
        )

    override fun getPopularMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Flow<Page<List<Movie>>> =
        remoteMovieDataSource.getPopularMovies(
            language,
            page,
            region
        )

    override fun getLatestMovies(
        language: String?
    ): Flow<Page<List<Movie>>> =
        remoteMovieDataSource.getLatestMovies(
            language
        )

    override fun getMovieRecommendations(
        movieId: Int,
        language: String?,
        page: Int?
    ): Flow<Page<List<Movie>>> =
        remoteMovieDataSource.getMovieRecommendations(
            movieId,
            language,
            page
        )

    override fun getMovieDetails(
        movieId: Int,
        language: String?,
        appendToResponse: String?
    ): Flow<Movie> =
        remoteMovieDataSource.getMovieDetails(
            movieId,
            language,
            appendToResponse
        )
    
}