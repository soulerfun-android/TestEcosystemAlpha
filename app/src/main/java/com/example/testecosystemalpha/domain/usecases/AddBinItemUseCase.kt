package com.example.testecosystemalpha.domain.usecases

import com.example.testecosystemalpha.domain.entity.BinInfoItem
import com.example.testecosystemalpha.domain.repository.Repository
import javax.inject.Inject

class AddBinItemUseCase @Inject constructor(
    private val repository: Repository
) {
    fun addBinItem(binInfoItem: BinInfoItem) {
        repository.addBinItem(binInfoItem)
    }
}