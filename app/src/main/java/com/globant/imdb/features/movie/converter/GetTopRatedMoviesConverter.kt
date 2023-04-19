package com.globant.imdb.features.movie.converter

import android.content.Context
import com.globant.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.globant.imdb.state.CommonResultConverter
import com.globant.imdb.features.movie.BelongsToCollection
import com.globant.imdb.features.movie.Genre
import com.globant.imdb.features.movie.MovieItemModel
import com.globant.imdb.features.movie.MovieListModel
import com.globant.imdb.features.movie.ProductionCompany
import com.globant.imdb.features.movie.ProductionCountry
import com.globant.imdb.features.movie.SpokenLanguage
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class GetTopRatedMoviesConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetTopRatedMoviesUseCase.Response, MovieListModel>() {

    override fun convertSuccess(response: GetTopRatedMoviesUseCase.Response): MovieListModel {
        return MovieListModel(
            page = response.data.page,
            results = response.data.results.map {
                MovieItemModel(
                    adult = it.adult,
                    backdropPath = it.backdropPath,
                    belongsToCollection = BelongsToCollection(
                        backdropPath = it.belongsToCollection?.backdropPath,
                        id = it.belongsToCollection?.id,
                        name = it.belongsToCollection?.name,
                        posterPath = it.belongsToCollection?.posterPath
                    ),
                    budget = it.budget,
                    genreIds = it.genreIds,
                    genres = it.genres?.map {
                        Genre(
                            id = it.id,
                            name = it.name
                        )
                    },
                    homepage = it.homepage,
                    id = it.id,
                    imdbId = it.imdbId,
                    originalLanguage = it.originalLanguage,
                    originalTitle = it.originalTitle,
                    overview = it.overview,
                    popularity = it.popularity,
                    posterPath = it.posterPath,
                    productionCompanies = it.productionCompanies?.map {
                        ProductionCompany(
                            id = it.id,
                            logoPath = it.logoPath,
                            name = it.name,
                            originCountry = it.originCountry
                        )
                    },
                    productionCountries = it.productionCountries?.map {
                        ProductionCountry(
                            iso31661 = it.iso31661,
                            name = it.name
                        )
                    },
                    releaseDate = it.releaseDate,
                    revenue = it.revenue,
                    runtime = it.runtime,
                    spokenLanguages = it.spokenLanguages?.map {
                        SpokenLanguage(
                            englishName = it.englishName,
                            iso6391 = it.iso6391,
                            name = it.name
                        )
                    },
                    status = it.status,
                    tagline = it.tagline,
                    title = it.title,
                    video = it.video,
                    voteAverage = it.voteAverage,
                    voteCount = it.voteCount
                )
            },
            totalPages = response.data.totalPages,
            totalResults = response.data.totalResults
        )
    }
}