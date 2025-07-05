package com.example.lelele.di

import android.app.Application
import com.example.testecosystemalpha.data.database.AppDatabase
import com.example.testecosystemalpha.data.database.BinItemsListDao
import com.example.testecosystemalpha.data.network.ApiFactory
import com.example.testecosystemalpha.data.network.ApiSerivce
import com.example.testecosystemalpha.data.repostiory.RepositoryImpl
import com.example.testecosystemalpha.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepository(impl: RepositoryImpl): Repository

    companion object {
        @Provides
        @ApplicationScope
        fun provideApiServiceCat(): ApiSerivce {
            return ApiFactory.apiSerivce
        }

        @ApplicationScope
        @Provides
        fun provideBinItemstDao(
            application: Application
        ): BinItemsListDao {
            return AppDatabase.getInstance(application).imageListDao()
        }
    }
}