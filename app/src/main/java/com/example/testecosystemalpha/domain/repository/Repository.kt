package com.example.testecosystemalpha.domain.repository

import androidx.lifecycle.LiveData
import com.example.testecosystemalpha.domain.entity.BinInfoItem

interface Repository {

    suspend fun getBinItem(bin: String): BinInfoItem

    fun deleteBinItem(binItemId: Int)

    fun addBinItem(binInfoItem: BinInfoItem)

    fun getBinItemsList(): List<BinInfoItem>

}