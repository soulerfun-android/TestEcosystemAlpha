package com.example.testecosystemalpha.domain.usecases

import com.example.testecosystemalpha.domain.entity.BinInfoItem
import com.example.testecosystemalpha.domain.repository.Repository
import javax.inject.Inject

class GetBinItemUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun getBinItem(bin: String): BinInfoItem {
        return repository.getBinItem(bin)
    }

}