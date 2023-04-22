package com.globant.imdb.ui.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.globant.imdb.R

enum class BottomBarItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    HOME(
        title = R.string.nav_home,
        icon = R.drawable.ic_home
    ),
    SEARCH(
        title = R.string.nav_search,
        icon = R.drawable.ic_search
    ),
    WATCH(
        title = R.string.nav_watch,
        icon = R.drawable.ic_play
    ),
    PROFILE(
        title = R.string.nav_profile,
        icon = R.drawable.ic_profile
    )
}