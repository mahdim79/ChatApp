package com.dust.exchat.di.module

import com.dust.exchat.framework.local.mapper.UserLocalMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MapperModule {
    @Singleton
    @Provides
    fun provideUserMapper():UserLocalMapper = UserLocalMapper()

}