package com.globant.domain.repository

import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

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