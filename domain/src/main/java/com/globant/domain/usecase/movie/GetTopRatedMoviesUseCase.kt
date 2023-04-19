package com.globant.domain.usecase.movie

import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.repository.MovieRepository
import com.globant.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTopRatedMoviesUseCase @Inject constructor(
    configuration: Configuration,
    private val movieRepository: MovieRepository
) : UseCase<GetTopRatedMoviesUseCase.Request, GetTopRatedMoviesUseCase.Response> (configuration) {

    override fun process(request: Request): Flow<Response> =
        movieRepository.getTopRatedMovies(
            language = request.language,
            page = request.page,
            region = request.region
        ).map {
            Response(it)
        }

    data class Request(
        val language: String?,
        val page: Int?,
        val region: String?
    ) : UseCase.Request

    data class Response(
        val data: Page<List<Movie>>
    ) : UseCase.Response

}