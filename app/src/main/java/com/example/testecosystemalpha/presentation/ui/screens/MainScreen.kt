package com.example.testecosystemalpha.presentation.ui.screens

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.testecosystemalpha.presentation.MainViewModel
import com.example.testecosystemalpha.presentation.ViewModelFactory
import com.example.testecosystemalpha.presentation.navigation.AppNavGraph
import com.example.testecosystemalpha.presentation.navigation.NavigationItem
import com.example.testecosystemalpha.presentation.navigation.rememberNavigationState

@Composable
fun MainScreen(viewModelFactory: ViewModelFactory) {

    val mainViewModel: MainViewModel = viewModel(
        factory = viewModelFactory
    )

    val navigationState = rememberNavigationState()

    Scaffold(bottomBar = {
        NavigationBar(
            containerColor = Color.LightGray
        ) {

            val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()

            val items = listOf(
                NavigationItem.Home, NavigationItem.Favourite
            )
            items.forEach { item ->

                val selected = navBackStackEntry?.destination?.hierarchy?.any {
                    it.route == item.screen.route
                } ?: false

                NavigationBarItem(
                    selected = selected,
                    onClick = {
                        if (!selected) {
                            navigationState.navigateTo(item.screen.route)
                        }
                    },
                    icon = {
                        Icon(
                            item.icon, contentDescription = null
                        )
                    },
                    label = {
                        Text(text = stringResource(id = item.titleResId))
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        selectedTextColor = MaterialTheme.colorScheme.onPrimary,
                        unselectedIconColor = MaterialTheme.colorScheme.onSecondary,
                        unselectedTextColor = MaterialTheme.colorScheme.onSecondary,
                        indicatorColor = Color.Black,
                    )
                )
            }
        }
    }) { paddingValues ->

        AppNavGraph(
            navHostController = navigationState.navHostController,
            homeScreenContent = {
                HomeScreen(paddingValues = paddingValues, viewModel = mainViewModel)
            },
            favouriteScreenContent = {
                BinItemListScreen(paddingValues = paddingValues, viewModel = mainViewModel)
            }
        )

    }
}