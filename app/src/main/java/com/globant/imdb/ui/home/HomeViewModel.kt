package com.globant.imdb.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.globant.domain.usecase.movie.GetTopRatedMoviesUseCase
import com.globant.imdb.state.UiState
import com.globant.imdb.features.movie.MovieListModel
import com.globant.imdb.features.movie.converter.GetTopRatedMoviesConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCase: GetTopRatedMoviesUseCase,
    private val converter: GetTopRatedMoviesConverter
) : ViewModel() {

    private val _getTopRatedMoviesFlow =
        MutableStateFlow<UiState<MovieListModel>>(UiState.Loading)
    val getTopRatedMoviesFlow: StateFlow<UiState<MovieListModel>> = _getTopRatedMoviesFlow

    fun getTopRatedMovies(
        language: String = "en-US",
        page: Int = 1,
        region: String = ""
    ) {
        viewModelScope.launch {
            useCase.execute(
                GetTopRatedMoviesUseCase.Request(
                    language = language,
                    page = page,
                    region = region
                )
            )
                .map {
                    converter.convert(it)
                }
                .collect {
                    _getTopRatedMoviesFlow.value = it
                }
        }
    }

}