package com.example.budget_buddy.di

import android.content.Context
import com.example.budget_buddy.data.database.FinanceItemDao
import com.example.budget_buddy.data.database.AppDatabase
import com.example.budget_buddy.data.datasources.FinanceItemDataSource
import com.example.budget_buddy.data.datasources.RoomFinanceItemDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun provideFinanceItemDao(appDatabase: AppDatabase): FinanceItemDao {
        return appDatabase.productDao()
    }

    @Provides
    @Singleton
    fun provideFinanceItemDataSource(item: FinanceItemDao): FinanceItemDataSource {
        return RoomFinanceItemDataSource(item)
    }
}