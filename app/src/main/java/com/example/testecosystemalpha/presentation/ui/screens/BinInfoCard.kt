package com.example.testecosystemalpha.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.testecosystemalpha.domain.entity.BinInfoItem

@Composable
fun BinInfoCard(binInfoItem: BinInfoItem) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.LightGray),
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            InfoLine(label = "BIN:", value = binInfoItem.binNumber)
            InfoLine(label = "Страна:", value = binInfoItem.country)
            InfoLine(label = "Координаты:", value = binInfoItem.coordinates)
            InfoLine(label = "Тип карты:", value = binInfoItem.type)
            InfoLine(label = "Банк:", value = binInfoItem.name)
            InfoLine(label = "Платёжная система:", value = binInfoItem.scheme)
            InfoLine(label = "Ссылка:", value = binInfoItem.url)
            InfoLine(label = "Телефон: ", value = binInfoItem.telephoneNumber)
            InfoLine(label = "Город:", value = binInfoItem.city)
        }
    }

}
