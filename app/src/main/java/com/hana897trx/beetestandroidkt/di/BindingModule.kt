package com.hana897trx.beetestandroidkt.di

import com.hana897trx.beetestandroidkt.data.remote.stories.StoriesRemoteDataSource
import com.hana897trx.beetestandroidkt.data.remote.stories.StoriesRemoteDataSourceImp
import com.hana897trx.beetestandroidkt.data.repository.stories.StoriesRepository
import com.hana897trx.beetestandroidkt.data.repository.stories.StoriesRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
 @Binds
 abstract fun provideStoriesRemoteDataSource(
  imp: StoriesRemoteDataSourceImp
 ): StoriesRemoteDataSource

 @Binds
 abstract fun provideStoriesRepository(
  imp: StoriesRepositoryImp
 ): StoriesRepository
}