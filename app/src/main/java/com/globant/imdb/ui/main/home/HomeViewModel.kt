package com.globant.imdb.ui.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.domain.usecase.movie.GetLatestMoviesUseCase
import com.globant.domain.usecase.movie.GetPopularMoviesUseCase
import com.globant.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.globant.imdb.state.UiState
import com.globant.imdb.features.movie.MovieListModel
import com.globant.imdb.features.movie.converter.GetLatestMoviesConverter
import com.globant.imdb.features.movie.converter.GetPopularMoviesConverter
import com.globant.imdb.features.movie.converter.GetTopRatedMoviesConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopRatedMoviesUseCase: GetTopRatedMoviesUseCase,
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getLatestMoviesUseCase: GetLatestMoviesUseCase,
    private val getTopRatedMoviesConverter: GetTopRatedMoviesConverter,
    private val getPopularMoviesConverter: GetPopularMoviesConverter,
    private val getLatestMoviesConverter: GetLatestMoviesConverter
) : ViewModel() {

    private val _getTopRatedMoviesFlow =
        MutableStateFlow<UiState<MovieListModel>>(UiState.Loading)
    val getTopRatedMoviesFlow: StateFlow<UiState<MovieListModel>> = _getTopRatedMoviesFlow

    private val _getPopularMoviesFlow =
        MutableStateFlow<UiState<MovieListModel>>(UiState.Loading)
    val getPopularMoviesFlow: StateFlow<UiState<MovieListModel>> = _getPopularMoviesFlow

    private val _getLatestMoviesFlow =
        MutableStateFlow<UiState<MovieListModel>>(UiState.Loading)
    val getLatestMoviesFlow: StateFlow<UiState<MovieListModel>> = _getLatestMoviesFlow

    init {
        getTopRatedMovies()
        getPopularMovies()
        getLatestMovies()
    }

    fun getTopRatedMovies(
        language: String = "en-US",
        page: Int = 1,
        region: String = ""
    ) {
        viewModelScope.launch {
            getTopRatedMoviesUseCase.execute(
                GetTopRatedMoviesUseCase.Request(
                    language = language,
                    page = page,
                    region = region
                )
            )
                .map {
                    getTopRatedMoviesConverter.convert(it)
                }
                .collect {
                    _getTopRatedMoviesFlow.value = it
                }
        }
    }

    fun getPopularMovies(
        language: String = "en-US",
        page: Int = 1,
        region: String = ""
    ) {
        viewModelScope.launch {
            getPopularMoviesUseCase.execute(
                GetPopularMoviesUseCase.Request(
                    language = language,
                    page = page,
                    region = region
                )
            )
                .map {
                    getPopularMoviesConverter.convert(it)
                }
                .collect {
                    _getPopularMoviesFlow.value = it
                }
        }
    }

    fun getLatestMovies(
        language: String = "en-US"
    ) {
        viewModelScope.launch {
            getLatestMoviesUseCase.execute(
                GetLatestMoviesUseCase.Request(
                    language = language
                )
            )
                .map {
                    getLatestMoviesConverter.convert(it)
                }
                .collect {
                    _getLatestMoviesFlow.value = it
                }
        }
    }

}