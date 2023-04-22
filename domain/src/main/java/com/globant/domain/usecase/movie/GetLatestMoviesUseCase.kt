package com.globant.domain.usecase.movie

import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.repository.MovieRepository
import com.globant.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetLatestMoviesUseCase @Inject constructor(
    configuration: UseCase.Configuration,
    private val movieRepository: MovieRepository
) : UseCase<GetLatestMoviesUseCase.Request, GetLatestMoviesUseCase.Response> (configuration) {

    override fun process(request: Request): Flow<Response> =
        movieRepository.getLatestMovies(
            language = request.language
        ).map {
            Response(it)
        }

    data class Request(
        val language: String?
    ) : UseCase.Request

    data class Response(
        val data: Page<List<Movie>>
    ) : UseCase.Response

}