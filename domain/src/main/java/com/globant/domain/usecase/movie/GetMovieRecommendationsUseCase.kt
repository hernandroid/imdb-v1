package com.globant.domain.usecase.movie

import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.repository.MovieRepository
import com.globant.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMovieRecommendationsUseCase @Inject constructor(
    configuration: Configuration,
    private val movieRepository: MovieRepository
) : UseCase<GetMovieRecommendationsUseCase.Request, GetMovieRecommendationsUseCase.Response> (configuration) {

    override fun process(request: Request): Flow<Response> =
        movieRepository.getMovieRecommendations(
            movieId = request.movieId,
            language = request.language,
            page = request.page
        ).map {
            Response(it)
        }

    data class Request(
        val movieId: Int,
        val language: String?,
        val page: Int?
    ) : UseCase.Request

    data class Response(
        val data: Page<List<Movie>>
    ) : UseCase.Response
}