package com.globant.imdb.navigation

import androidx.navigation.NamedNavArgument

private const val ROUTE_SPLASH = "splash"
private const val ROUTE_LOGIN = "login"
private const val ROUTE_SIGN_UP = "sign_up"
private const val ROUTE_MAIN = "main"
private const val ROUTE_HOME = "home"
private const val ROUTE_SEARCH = "search"
private const val ROUTE_DETAIL = "detail"
private const val ROUTE_PROFILE = "profile"

sealed class NavRoutes(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    object Splash : NavRoutes(ROUTE_SPLASH)

    object Login : NavRoutes(ROUTE_LOGIN)

    object SignUp : NavRoutes(ROUTE_SIGN_UP)

    object Main : NavRoutes(ROUTE_MAIN)

    object Home : NavRoutes(ROUTE_HOME)

    object Search : NavRoutes(ROUTE_SEARCH)

    object Detail : NavRoutes(ROUTE_DETAIL)

    object Profile : NavRoutes(ROUTE_PROFILE)

}