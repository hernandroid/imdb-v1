package com.globant.data.remote.networking.search

import com.google.gson.annotations.SerializedName

data class SearchMovieApiModel(
    @SerializedName(value = "page")
    val page: Int,
    @SerializedName(value = "results")
    val results: List<Result>,
    @SerializedName(value = "total_pages")
    val totalPages: Int,
    @SerializedName(value = "total_results")
    val totalResults: Int
)

data class Result(
    @SerializedName(value = "adult")
    val adult: Boolean,
    @SerializedName(value = "backdrop_path")
    val backdropPath: String,
    @SerializedName(value = "genre_ids")
    val genreIds: List<Int>,
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "original_language")
    val originalLanguage: String,
    @SerializedName(value = "original_title")
    val originalTitle: String,
    @SerializedName(value = "overview")
    val overview: String,
    @SerializedName(value = "popularity")
    val popularity: Double,
    @SerializedName(value = "poster_path")
    val posterPath: String,
    @SerializedName(value = "release_date")
    val releaseDate: String,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "video")
    val video: Boolean,
    @SerializedName(value = "vote_average")
    val voteAverage: Double,
    @SerializedName(value = "vote_count")
    val voteCount: Int
)