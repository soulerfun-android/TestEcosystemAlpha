package com.example.testecosystemalpha.presentation.navigation

sealed class Screen(
    val route: String
) {
    object Home : Screen(ROUTE_HOME)
    object Favourite : Screen(ROUTE_FAVOURITE)

    companion object {
        const val ROUTE_HOME = "home"
        const val ROUTE_FAVOURITE = "favourite"
    }
}