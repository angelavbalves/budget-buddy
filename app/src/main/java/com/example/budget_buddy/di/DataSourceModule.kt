package com.example.budget_buddy.di

import com.example.budget_buddy.data.database.FinanceItemDao
import com.example.budget_buddy.data.datasources.RoomFinanceItemDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    @Provides
    @Singleton
    fun providesFinanceItemDataSource(financeItemDao: FinanceItemDao): RoomFinanceItemDataSource {
        return RoomFinanceItemDataSource(financeItemDao)
    }
}
