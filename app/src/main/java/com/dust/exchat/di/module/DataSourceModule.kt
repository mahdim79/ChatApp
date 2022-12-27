package com.dust.exchat.di.module

import com.dust.core.data.local.LocalDataSource
import com.dust.exchat.framework.local.UserDao
import com.dust.exchat.framework.local.datasource.LocalDataSourceImpl
import com.dust.exchat.framework.local.mapper.UserLocalMapper
import com.dust.exchat.utils.PrefHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideLocalDataSource(userDao: UserDao,userLocalMapper: UserLocalMapper,prefHandler: PrefHandler):LocalDataSource{
        return LocalDataSourceImpl(userDao,userLocalMapper,prefHandler)
    }
}