package com.globant.data.remote.source

import com.globant.data.remote.networking.search.SearchMovieApiModel
import com.globant.data.remote.networking.search.SearchService
import com.globant.data.repository.source.remote.RemoteSearchDataSource
import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.model.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteSearchDataSourceImpl @Inject constructor(
    private val searchService: SearchService
) : RemoteSearchDataSource {

    override fun searchMovies(
        language: String?,
        query: String,
        page: Int?,
        includeAdult: String?,
        region: String?,
        year: Int?,
        primaryReleaseYear: Int?
    ): Flow<Page<List<Movie>>> = flow {
        emit(
            searchService.searchMovies(
                language,
                query,
                page,
                includeAdult,
                region,
                year,
                primaryReleaseYear
            )
        )
    }.map { data ->
        convertList(data)
    }.catch {
        throw UseCaseException.UnknownException(it)
    }

    private fun convertList(searchMovieApiModel: SearchMovieApiModel) =
        Page(
            page = searchMovieApiModel.page,
            results = searchMovieApiModel.results.map { item ->
                Movie(
                    adult = item.adult,
                    backdropPath = item.backdropPath,
                    genreIds = item.genreIds,
                    id = item.id,
                    originalLanguage = item.originalLanguage,
                    originalTitle = item.originalTitle,
                    overview = item.overview,
                    popularity = item.popularity,
                    posterPath = item.posterPath,
                    releaseDate = item.releaseDate,
                    title = item.title,
                    video = item.video,
                    voteAverage = item.voteAverage,
                    voteCount = item.voteCount
                )
            },
            totalPages = searchMovieApiModel.totalPages,
            totalResults = searchMovieApiModel.totalResults
        )

}