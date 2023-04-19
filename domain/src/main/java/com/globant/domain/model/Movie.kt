package com.globant.domain.model

data class Movie(
    val id: Int? = 0,
    val adult: Boolean? = null,
    val backdropPath: String? = null,
    val belongsToCollection: BelongsToCollection? = null,
    val budget: Int? = 0,
    val genreIds: List<Int>?,
    val genres: List<Genre>? = null,
    val homepage: String? = null,
    val imdbId: String? = null,
    val originalLanguage: String? = null,
    val originalTitle: String? = null,
    val overview: String? = null,
    val popularity: Double? = 0.0,
    val posterPath: String? = null,
    val productionCompanies: List<ProductionCompany>? = null,
    val productionCountries: List<ProductionCountry>? = null,
    val releaseDate: String? = null,
    val revenue: Int? = 0,
    val runtime: Int? = 0,
    val spokenLanguages: List<SpokenLanguage>? = null,
    val status: String? = null,
    val tagline: String? = null,
    val title: String? = null,
    val video: Boolean? = null,
    val voteAverage: Double? = 0.0,
    val voteCount: Int? = 0
) {
    data class BelongsToCollection(
        val backdropPath: String?,
        val id: Int?,
        val name: String?,
        val posterPath: String?
    )

    data class Genre(
        val id: Int?,
        val name: String?
    )

    data class ProductionCompany(
        val id: Int?,
        val logoPath: String?,
        val name: String?,
        val originCountry: String?
    )

    data class ProductionCountry(
        val iso31661: String?,
        val name: String?
    )

    data class SpokenLanguage(
        val englishName: String?,
        val iso6391: String?,
        val name: String?
    )
}