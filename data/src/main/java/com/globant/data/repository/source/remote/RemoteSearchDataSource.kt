package com.globant.data.repository.source.remote

import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import kotlinx.coroutines.flow.Flow

interface RemoteSearchDataSource {

    fun searchMovies(
        language: String?,
        query: String,
        page: Int?,
        includeAdult: String?,
        region: String?,
        year: Int?,
        primaryReleaseYear: Int?,
    ): Flow<Page<List<Movie>>>

}