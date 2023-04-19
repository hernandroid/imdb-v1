package com.globant.data.repository.impl

import com.globant.data.repository.source.remote.RemoteSearchDataSource
import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val remoteSearchDataSource: RemoteSearchDataSource
) : SearchRepository {

    override fun searchMovies(
        language: String?,
        query: String,
        page: Int?,
        includeAdult: String?,
        region: String?,
        year: Int?,
        primaryReleaseYear: Int?
    ): Flow<Page<List<Movie>>> =
        remoteSearchDataSource.searchMovies(
            language,
            query,
            page,
            includeAdult,
            region,
            year,
            primaryReleaseYear
        )
}