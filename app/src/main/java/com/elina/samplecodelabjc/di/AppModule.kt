package com.elina.samplecodelabjc.di

import com.elina.samplecodelabjc.domain.repository.CategoryRepository
import com.elina.samplecodelabjc.domain.repository.HomeRepository
import com.elina.samplecodelabjc.domain.repository.OfferRepository
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

    @Provides
    fun provideCategoryRepository(): CategoryRepository = CategoryRepository()

    @Provides
    fun provideOfferRepository(): OfferRepository = OfferRepository()
}
    