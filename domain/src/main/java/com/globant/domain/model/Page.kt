package com.globant.domain.model

data class Page<T>(
    val page: Int,
    val results: T,
    val totalPages: Int,
    val totalResults: Int
)