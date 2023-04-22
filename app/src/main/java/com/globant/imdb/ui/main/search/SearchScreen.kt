package com.globant.imdb.ui.main.watch

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.globant.imdb.ui.main.search.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel,
    navController: NavController
) {
    Text(
        text = "SEARCH",
        fontSize = 24.sp
    )
}