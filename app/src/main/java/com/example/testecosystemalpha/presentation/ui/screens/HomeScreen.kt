package com.example.testecosystemalpha.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.testecosystemalpha.domain.entity.BinInfoItem
import com.example.testecosystemalpha.presentation.MainViewModel
import com.example.testecosystemalpha.presentation.ui.screen_states.BinInfoScreenState

@Composable
fun HomeScreen(paddingValues: PaddingValues, viewModel: MainViewModel) {

    val screenState =
        viewModel.newsItemsState.collectAsState(BinInfoScreenState.Initial)

    when (val currentState = screenState.value) {

        is BinInfoScreenState.Initial -> {
            LoadingScreen()
        }

        is BinInfoScreenState.BinInfoScreen -> {
            val binInfoItem = currentState.binItem
            BinInfoScreen(binInfoItem, viewModel, paddingValues)
        }
    }
}


@SuppressLint("RememberReturnType", "StateFlowValueCalledInComposition")
@Composable
fun BinInfoScreen(
    binInfoItem: BinInfoItem,
    viewModel: MainViewModel,
    paddingValues: PaddingValues
) {

    val textState = remember { mutableStateOf("") }
    val searchActivity = viewModel.searchState.collectAsState()

    Surface(
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues = paddingValues)
    ) {
        Column(horizontalAlignment = Alignment.Start, modifier = Modifier.padding(16.dp)) {

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Информация о карте",
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(16.dp))

            BinInfoCard(binInfoItem)

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = textState.value,
                onValueChange = { newText ->
                    textState.value = newText
                },
                placeholder = { Text("Введите BIN номер") },
                modifier = Modifier.fillMaxWidth(),
                label = { Text("BIN номер") },
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                enabled = searchActivity.value,
                onClick = {
                    viewModel.loadCardInfo(textState.value)
                }
            ) {
                Text("Поиск")
            }

            Spacer(modifier = Modifier.height(16.dp))

            if (!searchActivity.value) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun InfoLine(label: String, value: String) {
    Row(modifier = Modifier.padding(top = 8.dp)) {
        Text(
            text = "$label ",
            style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Medium),
            color = Color.DarkGray
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}