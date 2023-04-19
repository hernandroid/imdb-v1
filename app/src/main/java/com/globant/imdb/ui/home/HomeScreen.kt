package com.globant.imdb.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.globant.imdb.state.CommonScreen
import com.globant.imdb.features.movie.MovieListModel
import com.globant.imdb.ui.theme.Charcoal
import com.globant.imdb.ui.theme.Nobel
import com.globant.imdb.ui.theme.White

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController
) {
    viewModel.getTopRatedMovies()
    viewModel.getTopRatedMoviesFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column(
                modifier = Modifier
                    .background(White)
                    .fillMaxWidth()
            ) {
                TopRatedMovies(it)
            }
        }
    }
}

@Composable
fun TopRatedMovies(
    movieListModel: MovieListModel
) {
    LazyColumn(
        modifier = Modifier
            .padding(23.dp)
    ) {
        items(movieListModel.results) { item ->
            Divider(
                color = Nobel.copy(alpha = 0.2F)
            )
            Spacer(
                Modifier.height(10.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        "https://image.tmdb.org/t/p/w500${item.posterPath}"
                    ),
                    contentDescription = "Movie image",
                    modifier = Modifier
                        .height(106.dp)
                        .width(74.dp),
                    contentScale = ContentScale.None
                )
                Spacer(
                    Modifier.width(15.dp)
                )
                Column {
                    item.title?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Charcoal,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(
                        Modifier.height(6.dp)
                    )
                    item.releaseDate?.let {
                        Text(
                            text = it.substring(0, 4),
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Nobel,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(
                        Modifier.height(20.dp)
                    )
                    item.overview?.let {
                        Text(
                            text = it,
                            maxLines = 1,
                            modifier = Modifier
                                .fillMaxWidth(),
                            color = Nobel,
                            fontSize = 14.sp
                        )
                    }
                }
            }
            Spacer(
                Modifier.height(10.dp)
            )
        }
    }
}