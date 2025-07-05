package com.example.testecosystemalpha.domain.usecases

import androidx.lifecycle.LiveData
import com.example.testecosystemalpha.domain.entity.BinInfoItem
import com.example.testecosystemalpha.domain.repository.Repository
import javax.inject.Inject

class GetBinItemListUseCase @Inject constructor(
    private val repository: Repository
) {

    fun getBinItemList(): List<BinInfoItem> {
        return repository.getBinItemsList()
    }
}