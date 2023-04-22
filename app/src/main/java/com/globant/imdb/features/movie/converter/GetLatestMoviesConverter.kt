package com.globant.imdb.features.movie.converter

import com.globant.domain.usecase.movie.GetLatestMoviesUseCase
import com.globant.imdb.features.movie.BelongsToCollection
import com.globant.imdb.features.movie.Genre
import com.globant.imdb.features.movie.MovieItemModel
import com.globant.imdb.features.movie.MovieListModel
import com.globant.imdb.features.movie.ProductionCompany
import com.globant.imdb.features.movie.ProductionCountry
import com.globant.imdb.features.movie.SpokenLanguage
import com.globant.imdb.state.CommonResultConverter
import javax.inject.Inject

class GetLatestMoviesConverter @Inject constructor(
) : CommonResultConverter<GetLatestMoviesUseCase.Response, MovieListModel>() {

    override fun convertSuccess(response: GetLatestMoviesUseCase.Response): MovieListModel {
        return MovieListModel(
            page = response.data.page,
            results = response.data.results.map {
                MovieItemModel(
                    adult = it.adult ?: false,
                    backdropPath = it.backdropPath ?: "",
                    belongsToCollection = BelongsToCollection(
                        backdropPath = it.belongsToCollection?.backdropPath ?: "",
                        id = it.belongsToCollection?.id ?: 0,
                        name = it.belongsToCollection?.name ?: "",
                        posterPath = it.belongsToCollection?.posterPath ?: ""
                    ),
                    budget = it.budget ?: 0,
                    genreIds = it.genreIds ?: listOf(),
                    genres = it.genres?.map {
                        Genre(
                            id = it.id ?: 0,
                            name = it.name ?: ""
                        )
                    } ?: listOf(),
                    homepage = it.homepage ?: "",
                    id = it.id ?: 0,
                    imdbId = it.imdbId ?: "",
                    originalLanguage = it.originalLanguage ?: "",
                    originalTitle = it.originalTitle ?: "",
                    overview = it.overview ?: "",
                    popularity = it.popularity ?: 0.0,
                    posterPath = it.posterPath ?: "",
                    productionCompanies = it.productionCompanies?.map {
                        ProductionCompany(
                            id = it.id ?: 0,
                            logoPath = it.logoPath ?: "",
                            name = it.name ?: "",
                            originCountry = it.originCountry ?: ""
                        )
                    } ?: listOf(),
                    productionCountries = it.productionCountries?.map {
                        ProductionCountry(
                            iso31661 = it.iso31661 ?: "",
                            name = it.name ?: ""
                        )
                    } ?: listOf(),
                    releaseDate = it.releaseDate ?: "",
                    revenue = it.revenue ?: 0,
                    runtime = it.runtime ?: 0,
                    spokenLanguages = it.spokenLanguages?.map {
                        SpokenLanguage(
                            englishName = it.englishName ?: "",
                            iso6391 = it.iso6391 ?: "",
                            name = it.name ?: ""
                        )
                    } ?: listOf(),
                    status = it.status ?: "",
                    tagline = it.tagline ?: "",
                    title = it.title ?: "",
                    video = it.video ?: false,
                    voteAverage = it.voteAverage ?: 0.0,
                    voteCount = it.voteCount ?: 0
                )
            },
            totalPages = response.data.totalPages,
            totalResults = response.data.totalResults
        )
    }
}