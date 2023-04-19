package com.globant.data.remote.networking.movie

import com.google.gson.annotations.SerializedName

data class MovieListApiModel(
    @SerializedName(value = "page")
    val page: Int,
    @SerializedName(value = "results")
    val results: List<MovieItemApiModel>,
    @SerializedName(value = "total_pages")
    val totalPages: Int,
    @SerializedName(value = "total_results")
    val totalResults: Int
)

data class MovieItemApiModel(
    @SerializedName(value = "adult")
    val adult: Boolean,
    @SerializedName(value = "backdrop_path")
    val backdropPath: String,
    @SerializedName(value = "belongs_to_collection")
    val belongsToCollection: BelongsToCollection?,
    @SerializedName(value = "budget")
    val budget: Int,
    @SerializedName(value = "genre_ids")
    val genreIds: List<Int>,
    @SerializedName(value = "genres")
    val genres: List<Genre>,
    @SerializedName(value = "homepage")
    val homepage: String,
    @SerializedName(value = "id")
    val id: Int,
    @SerializedName(value = "imdb_id")
    val imdbId: String,
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
    @SerializedName(value = "production_companies")
    val productionCompanies: List<ProductionCompany>,
    @SerializedName(value = "production_countries")
    val productionCountries: List<ProductionCountry>,
    @SerializedName(value = "release_date")
    val releaseDate: String,
    @SerializedName(value = "revenue")
    val revenue: Int,
    @SerializedName(value = "runtime")
    val runtime: Int,
    @SerializedName(value = "spoken_languages")
    val spokenLanguages: List<SpokenLanguage>,
    @SerializedName(value = "status")
    val status: String,
    @SerializedName(value = "tagline")
    val tagline: String,
    @SerializedName(value = "title")
    val title: String,
    @SerializedName(value = "video")
    val video: Boolean,
    @SerializedName(value = "vote_average")
    val voteAverage: Double,
    @SerializedName(value = "vote_count")
    val voteCount: Int
) {
    data class BelongsToCollection(
        @SerializedName(value = "backdrop_path")
        val backdropPath: String,
        @SerializedName(value = "id")
        val id: Int,
        @SerializedName(value = "name")
        val name: String,
        @SerializedName(value = "poster_path")
        val posterPath: String
    )

    data class Genre(
        @SerializedName(value = "id")
        val id: Int,
        @SerializedName(value = "name")
        val name: String
    )

    data class ProductionCompany(
        @SerializedName(value = "id")
        val id: Int,
        @SerializedName(value = "logo_path")
        val logoPath: String,
        @SerializedName(value = "name")
        val name: String,
        @SerializedName(value = "origin_country")
        val originCountry: String
    )

    data class ProductionCountry(
        @SerializedName(value = "iso_3166_1")
        val iso31661: String,
        @SerializedName(value = "name")
        val name: String
    )

    data class SpokenLanguage(
        @SerializedName(value = "english_name")
        val englishName: String,
        @SerializedName(value = "iso_639_1")
        val iso6391: String,
        @SerializedName(value = "name")
        val name: String
    )
}