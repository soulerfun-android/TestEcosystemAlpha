package com.example.testecosystemalpha.domain.usecases

import com.example.testecosystemalpha.domain.entity.BinInfoItem
import com.example.testecosystemalpha.domain.repository.Repository
import javax.inject.Inject

class DeleteBinItemUseCase @Inject constructor(
    private val repository: Repository
) {
    fun deleteBinItem(binItemId: Int) {
        repository.deleteBinItem(binItemId)
    }
}