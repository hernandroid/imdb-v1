package com.globant.imdb.ui.main.profile

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    navController: NavController
) {
    Text(
        text = "PROFILE",
        fontSize = 24.sp
    )
}