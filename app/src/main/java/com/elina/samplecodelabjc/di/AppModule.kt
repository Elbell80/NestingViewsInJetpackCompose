package com.elina.samplecodelabjc.di

import com.elina.samplecodelabjc.feature.shared.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Elina on 13/06/2023.
 */

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideHomeRepository(): HomeRepository = HomeRepository()
}
    