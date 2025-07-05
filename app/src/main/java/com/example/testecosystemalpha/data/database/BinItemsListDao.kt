package com.example.testecosystemalpha.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BinItemsListDao {
    @Query("SELECT * FROM bin_items")
    fun getImageList(): List<BinItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addImageItem(imageItemDbModel: BinItemDbModel)

    @Query("DELETE FROM bin_items WHERE id=:binItemId")
    fun deleteImageItem(binItemId: Int)

}