package com.dust.exchat.di.module

import com.dust.exchat.framework.firebase.AuthManager
import com.dust.exchat.framework.firebase.DatabaseManager
import com.dust.exchat.framework.firebase.mapper.UserHashMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FirebaseModule {
    @Provides
    @Singleton
    fun provideAuthManager():AuthManager = AuthManager()

    @Provides
    @Singleton
    fun provideDbManager(userHashMapper: UserHashMapper):DatabaseManager = DatabaseManager(userHashMapper)

}