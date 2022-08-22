package com.hana897trx.beetestandroidkt.di

import com.hana897trx.beetestandroidkt.utils.NetworkConfig.API_KEY
import com.hana897trx.beetestandroidkt.utils.NetworkConfig.SECRET_KEY
import com.kumulos.android.KumulosConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppDI {
    @Singleton
    @Provides
    fun provideAPI() : KumulosConfig =
        KumulosConfig
            .Builder(API_KEY, SECRET_KEY)
            .build()
}