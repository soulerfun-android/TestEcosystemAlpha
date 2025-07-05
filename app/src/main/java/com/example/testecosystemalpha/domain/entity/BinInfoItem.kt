package com.example.testecosystemalpha.domain.entity

data class BinInfoItem(
    val binId: Int = 0,
    val binNumber: String,
    val country: String = "no data",
    val coordinates: String = "no data",
    val type: String = "no data",
    val url: String = "no data",
    val telephoneNumber: String = "no data",
    val name: String = "no data",
    val city: String = "no data",
    val scheme: String = "no data"
)