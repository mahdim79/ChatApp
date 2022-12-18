package com.dust.exchat.di.module

import com.dust.core.data.repo.UserRepository
import com.dust.core.usecase.SetUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideSetUser(userRepository: UserRepository):SetUser{
        return SetUser(userRepository)
    }
}