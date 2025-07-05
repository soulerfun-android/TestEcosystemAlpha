package com.example.testecosystemalpha.presentation.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.testecosystemalpha.presentation.MainViewModel
import com.example.testecosystemalpha.presentation.ui.screen_states.BinItemListScreenStates


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BinItemListScreen(viewModel: MainViewModel, paddingValues: PaddingValues) {
    val screenState =
        viewModel.binItemsState.collectAsState(BinItemListScreenStates.Initial)

    when (val currentState = screenState.value) {

        is BinItemListScreenStates.BinInfoScreen -> {
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                items(currentState.binItems, key = { it.binId }) { binItem ->

                    val dismissState = rememberSwipeToDismissBoxState()

                    if (dismissState.currentValue == SwipeToDismissBoxValue.EndToStart) {
                        viewModel.deleteBinItem(binItem.binId)
                    }

                    SwipeToDismissBox(
                        state = dismissState,
                        enableDismissFromStartToEnd = false,
                        backgroundContent = {

                        }
                    ) {
                        BinInfoCard(binItem)
                    }
                }
            }
        }

        BinItemListScreenStates.Initial -> {
            LoadingScreen()
        }
    }
}