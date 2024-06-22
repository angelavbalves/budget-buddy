package com.example.budget_buddy.di

import android.content.Context
import com.example.budget_buddy.presentation.providers.ResourcesProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResourcesModule {
    @Provides
    @Singleton
    fun provideResourcesProvider(context: Context): ResourcesProvider {
        return ResourcesProvider(context)
    }
}
