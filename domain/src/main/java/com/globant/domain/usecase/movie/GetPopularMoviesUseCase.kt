package com.globant.domain.usecase.movie

import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.repository.MovieRepository
import com.globant.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    configuration: UseCase.Configuration,
    private val movieRepository: MovieRepository
) : UseCase<GetPopularMoviesUseCase.Request, GetPopularMoviesUseCase.Response> (configuration) {

    override fun process(request: GetPopularMoviesUseCase.Request): Flow<Response> =
        movieRepository.getPopularMovies(
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