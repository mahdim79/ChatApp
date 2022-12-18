package com.dust.exchat.di.module

import com.dust.core.data.repo.UserRepository
import com.dust.core.data.local.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Singleton
    @Provides
    fun provideUserRepository(localDataSource: LocalDataSource): UserRepository {
        return UserRepository(localDataSource)
    }
}