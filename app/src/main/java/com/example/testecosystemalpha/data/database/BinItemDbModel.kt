package com.example.testecosystemalpha.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bin_items")
data class BinItemDbModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
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