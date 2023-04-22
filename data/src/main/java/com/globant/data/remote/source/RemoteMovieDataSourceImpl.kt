package com.globant.data.remote.source

import com.globant.data.remote.networking.movie.MovieItemApiModel
import com.globant.data.remote.networking.movie.MovieListApiModel
import com.globant.data.remote.networking.movie.MovieService
import com.globant.data.repository.source.remote.RemoteMovieDataSource
import com.globant.domain.model.Movie
import com.globant.domain.model.Page
import com.globant.domain.model.UseCaseException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteMovieDataSourceImpl @Inject constructor(
    private val movieService: MovieService
) : RemoteMovieDataSource {

    override fun getTopRatedMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Flow<Page<List<Movie>>> = flow {
        emit(
            movieService.getTopRatedMovies(
                language,
                page,
                region
            )
        )
    }.map { data ->
        convertList(data)
    }.catch {
        throw UseCaseException.UnknownException(it)
    }

    override fun getPopularMovies(
        language: String?,
        page: Int?,
        region: String?
    ): Flow<Page<List<Movie>>> = flow {
        emit(
            movieService.getPopularMovies(
                language,
                page,
                region
            )
        )
    }.map { data ->
        convertList(data)
    }.catch {
        throw UseCaseException.UnknownException(it)
    }

    override fun getLatestMovies(
        language: String?
    ): Flow<Page<List<Movie>>> = flow {
        emit(
            movieService.getLatestMovies(
                language
            )
        )
    }.map { data ->
        convertList(data)
    }.catch {
        throw UseCaseException.UnknownException(it)
    }

    override fun getMovieRecommendations(
        movieId: Int,
        language: String?,
        page: Int?
    ): Flow<Page<List<Movie>>> = flow {
        emit(
            movieService.getMovieRecommendations(
                movieId,
                language,
                page
            )
        )
    }.map { data ->
        convertList(data)
    }.catch {
        throw UseCaseException.UnknownException(it)
    }

    override fun getMovieDetails(
        movieId: Int,
        language: String?,
        appendToResponse: String?
    ): Flow<Movie> = flow {
        emit(
            movieService.getMovieDetails(
                movieId,
                language,
                appendToResponse
            )
        )
    }.map { data ->
        convertItem(data)
    }.catch {
        throw UseCaseException.UnknownException(it)
    }

    private fun convertList(movieListApiModel: MovieListApiModel) =
        Page(
            page = movieListApiModel.page,
            results = movieListApiModel.results.map { item ->
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
            totalPages = movieListApiModel.totalPages,
            totalResults = movieListApiModel.totalResults
        )

    private fun convertItem(movieItemApiModel: MovieItemApiModel) =
        Movie(
            adult = movieItemApiModel.adult,
            backdropPath = movieItemApiModel.backdropPath,
            belongsToCollection = Movie.BelongsToCollection(
                backdropPath = movieItemApiModel.belongsToCollection?.backdropPath,
                id = movieItemApiModel.belongsToCollection?.id,
                name = movieItemApiModel.belongsToCollection?.name,
                posterPath = movieItemApiModel.belongsToCollection?.posterPath
            ),
            budget = movieItemApiModel.budget,
            genreIds = movieItemApiModel.genreIds,
            genres = movieItemApiModel.genres.map {
                Movie.Genre(
                    id = it.id,
                    name = it.name
                )
            },
            homepage = movieItemApiModel.homepage,
            id = movieItemApiModel.id,
            imdbId = movieItemApiModel.imdbId,
            originalLanguage = movieItemApiModel.originalLanguage,
            originalTitle = movieItemApiModel.originalTitle,
            overview = movieItemApiModel.overview,
            popularity = movieItemApiModel.popularity,
            posterPath = movieItemApiModel.posterPath,
            productionCompanies = movieItemApiModel.productionCompanies.map {
                Movie.ProductionCompany(
                    id = it.id,
                    logoPath = it.logoPath,
                    name = it.name,
                    originCountry = it.originCountry
                )
            },
            productionCountries = movieItemApiModel.productionCountries.map {
                Movie.ProductionCountry(
                    iso31661 = it.iso31661,
                    name = it.name
                )
            },
            releaseDate = movieItemApiModel.releaseDate,
            revenue = movieItemApiModel.revenue,
            runtime = movieItemApiModel.runtime,
            spokenLanguages = movieItemApiModel.spokenLanguages.map {
                Movie.SpokenLanguage(
                    englishName = it.englishName,
                    iso6391 = it.iso6391,
                    name = it.name
                )
            },
            status = movieItemApiModel.status,
            tagline = movieItemApiModel.tagline,
            title = movieItemApiModel.title,
            video = movieItemApiModel.video,
            voteAverage = movieItemApiModel.voteAverage,
            voteCount = movieItemApiModel.voteCount
        )

}