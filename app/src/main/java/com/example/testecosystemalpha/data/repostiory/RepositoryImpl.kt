package com.example.testecosystemalpha.data.repostiory

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.example.testecosystemalpha.data.database.BinItemsListDao
import com.example.testecosystemalpha.data.mapper.Mapper
import com.example.testecosystemalpha.data.network.ApiSerivce
import com.example.testecosystemalpha.domain.entity.BinInfoItem
import com.example.testecosystemalpha.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val mapper: Mapper,
    private val apiSerivce: ApiSerivce,
    private val binItemsListDao: BinItemsListDao

) : Repository {

    override suspend fun getBinItem(bin: String): BinInfoItem {
        val binInfo = apiSerivce.getInfo(bin)
        return mapper.mapDtoItemToEntity(binInfo)
    }

    override fun deleteBinItem(binItemId: Int) {
        binItemsListDao.deleteImageItem(binItemId)
    }

    override fun addBinItem(binItem: BinInfoItem) {
        binItemsListDao.addImageItem(mapper.mapEntityToDbModel(binItem))
    }

    override fun getBinItemsList(): List<BinInfoItem> =
        binItemsListDao.getImageList().map {
            mapper.mapDbModelToEntity(it)
        }
}