package com.globant.imdb.ui.main.watch

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun WatchScreen(
    viewModel: WatchViewModel,
    navController: NavController
) {
    Text(
        text = "WATCH",
        fontSize = 24.sp
    )
}