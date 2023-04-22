package com.globant.imdb.ui.main

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.globant.imdb.ui.main.home.HomeScreen
import com.globant.imdb.ui.main.profile.ProfileScreen
import com.globant.imdb.ui.main.watch.SearchScreen
import com.globant.imdb.ui.main.watch.WatchScreen
import com.globant.imdb.ui.theme.Black
import com.globant.imdb.ui.theme.DarkGoldenrod
import com.globant.imdb.ui.theme.GoldenPoppy

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MainScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    val (currentBottomTab, setCurrentBottomTab) = rememberSaveable {
        mutableStateOf(BottomBarItem.HOME)
    }
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    Crossfade(currentBottomTab) { bottomTab ->
        Scaffold(
            scaffoldState = scaffoldState,
            bottomBar = { MainBottomNavigation(bottomTab, setCurrentBottomTab) },
            content = {
                val modifier = Modifier.padding(it)
                when (bottomTab) {
                    BottomBarItem.HOME -> HomeScreen(
                        viewModel = hiltViewModel(),
                        navController = navController
                    )

                    BottomBarItem.SEARCH -> SearchScreen(
                        viewModel = hiltViewModel(),
                        navController = navController
                    )

                    BottomBarItem.WATCH -> WatchScreen(
                        viewModel = hiltViewModel(),
                        navController = navController
                    )

                    BottomBarItem.PROFILE -> ProfileScreen(
                        viewModel = hiltViewModel(),
                        navController = navController
                    )
                }
            }
        )
    }
}

@Composable
fun MainBottomNavigation(
    bottomTab: BottomBarItem,
    setCurrentBottomTab: (BottomBarItem) -> Unit
) {
    val bottomBarHeight = 75.dp
    val pages = BottomBarItem.values()

    BottomNavigation(
        backgroundColor = GoldenPoppy,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        pages.forEach { page ->
            val selected = page == bottomTab
            val selectedLabelColor = if (selected) Black else DarkGoldenrod
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(page.icon),
                        contentDescription = stringResource(page.title))
                },
                label = {
                    Text(
                        text = stringResource(page.title),
                        color = selectedLabelColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                },
                selected = selected,
                onClick = {
                    setCurrentBottomTab.invoke(page)
                },
                selectedContentColor = Black,
                unselectedContentColor = DarkGoldenrod,
                alwaysShowLabel = true,
                modifier = Modifier.navigationBarsPadding()
            )
        }
    }
}