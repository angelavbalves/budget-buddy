package com.example.budget_buddy.di

import com.example.budget_buddy.data.datasources.FinanceItemDataSource
import com.example.budget_buddy.data.repositories.FinanceItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesFinanceItemRepository(dataSource: FinanceItemDataSource): FinanceItemRepository {
        return FinanceItemRepository(dataSource)
    }
}