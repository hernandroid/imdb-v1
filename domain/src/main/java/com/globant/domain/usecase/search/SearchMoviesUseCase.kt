package com.globant.domain.usecase.search

import android.content.res.Configuration
import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.repository.SearchRepository
import com.globant.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchMoviesUseCase @Inject constructor(
    configuration: Configuration,
    private val searchRepository: SearchRepository
) : UseCase<SearchMoviesUseCase.Request, SearchMoviesUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        searchRepository.searchMovies(
            language = request.language,
            query = request.query,
            page = request.page,
            includeAdult = request.includeAdult,
            region = request.region,
            year = request.year,
            primaryReleaseYear = request.primaryReleaseYear
        ).map {
            Response(it)
        }

    data class Request(
        val language: String?,
        val query: String,
        val page: Int?,
        val includeAdult: String?,
        val region: String?,
        val year: Int?,
        val primaryReleaseYear: Int?
    ) : UseCase.Request

    data class Response(
        val data: Page<List<Movie>>
    ) : UseCase.Response

}