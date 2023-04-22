package com.globant.imdb.ui.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.globant.imdb.R
import com.globant.imdb.features.movie.MovieItemModel
import com.globant.imdb.state.CommonScreen
import com.globant.imdb.features.movie.MovieListModel
import com.globant.imdb.ui.theme.Black
import com.globant.imdb.ui.theme.Charcoal
import com.globant.imdb.ui.theme.GoldenPoppy
import com.globant.imdb.ui.theme.Nobel
import com.globant.imdb.ui.theme.White
import com.globant.imdb.ui.theme.WhiteSmoke

@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    navController: NavController
) {
    val topRatedMoviesState by viewModel.getTopRatedMoviesFlow.collectAsState()
    val popularMovies by viewModel.getPopularMoviesFlow.collectAsState()
    val latestMovies by viewModel.getLatestMoviesFlow.collectAsState()

    viewModel.getTopRatedMoviesFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column(
                modifier = Modifier
                    .background(WhiteSmoke)
                    .fillMaxWidth()
            ) {
                ShowMovies(
                    "Las más valoradas",
                    it
                )
            }
        }
    }

    viewModel.getPopularMoviesFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column(
                modifier = Modifier
                    .background(WhiteSmoke)
                    .fillMaxWidth()
            ) {
                ShowMovies(
                    "Las más populares",
                    it
                )
            }
        }
    }

    viewModel.getLatestMoviesFlow.collectAsState().value.let { state ->
        CommonScreen(state = state) {
            Column(
                modifier = Modifier
                    .background(WhiteSmoke)
                    .fillMaxWidth()
            ) {
                ShowMovies(
                    "Las más recientes",
                    it
                )
            }
        }
    }
}

@Composable
fun ShowMovies(
    title: String,
    movieListModel: MovieListModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(White)
            .height(332.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(
                    top = 16.dp,
                    start = 21.dp
                )
        ) {
            Card(
                shape = RoundedCornerShape(4.dp),
                modifier = Modifier.size(width = 6.dp, height = 25.dp)
            ) {
                Divider(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(GoldenPoppy)
                )
            }

            Text(
                text = title,
                modifier = Modifier
                    .padding(
                        horizontal = 8.dp
                    ),
                style = MaterialTheme.typography.h6.copy(
                    color = Black,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        LazyRow(
            modifier = Modifier
                .padding(
                    top = 32.dp
                )
        ) {
            items(movieListModel.results) {
                MovieItem(it)
            }
        }
    }
}

@Composable
fun MovieItem(
    movieItemModel: MovieItemModel
) {
    Column(modifier = Modifier
        .padding(
            start = 21.dp
        )) {
        Card(
            elevation = 6.dp,
            modifier = Modifier
                .clickable { }
        ) {
            Column(
                modifier = Modifier
                    .size(
                        width = 110.dp,
                        height = 225.dp
                    )
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        "https://image.tmdb.org/t/p/w500${movieItemModel.posterPath}"
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(width = 110.dp, height = 160.dp)
                )

                Column(
                    modifier = Modifier
                        .padding(
                            top = 8.dp,
                            start = 8.dp,
                            end = 7.dp,
                            bottom = 9.dp
                        )
                        .fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_star_rate),
                            contentDescription = null,
                            tint = GoldenPoppy,
                            modifier = Modifier
                                .width(12.dp)
                                .height(12.dp)
                        )

                        Text(
                            text = movieItemModel.voteAverage.toString(),
                            fontSize = 10.sp,
                            color = Charcoal,
                            modifier = Modifier
                                .padding(start = 6.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = movieItemModel.title,
                        maxLines = 1,
                        fontSize = 10.sp,
                        color = Black
                    )
                    
                    Spacer(modifier = Modifier.height(3.dp))

                    Icon(
                        painter = painterResource(id = R.drawable.ic_info),
                        contentDescription = null,
                        tint = Nobel,
                        modifier = Modifier
                            .align(Alignment.End)
                            .width(14.dp)
                            .height(14.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TopRatedMoviesOld(
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