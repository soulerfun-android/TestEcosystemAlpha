package com.example.testecosystemalpha.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.testecosystemalpha.R

sealed class NavigationItem(
    val screen: Screen,
    val titleResId: Int,
    val icon: ImageVector
) {
    object Home : NavigationItem(
        screen = Screen.Home,
        titleResId = R.string.info,
        icon = Icons.Outlined.Search
    )

    object Favourite : NavigationItem(
        screen = Screen.Favourite,
        titleResId = R.string.all_info,
        icon = Icons.Outlined.Favorite
    )
}
