package com.globant.domain.usecase.movie

import com.globant.domain.model.Movie
import com.globant.domain.repository.MovieRepository
import com.globant.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    configuration: Configuration,
    private val movieRepository: MovieRepository
) : UseCase<GetMovieDetailsUseCase.Request, GetMovieDetailsUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        movieRepository.getMovieDetails(
            movieId = request.movieId,
            language = request.language,
            appendToResponse = request.appendToResponse
        ).map {
            Response(it)
        }

    data class Request(
        val movieId: Int,
        val language: String?,
        val appendToResponse: String?
    ) : UseCase.Request

    data class Response(
        val data: Movie
    ) : UseCase.Response

}