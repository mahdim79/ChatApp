package com.dust.exchat.di.module

import android.content.Context
import androidx.room.Room
import com.dust.exchat.framework.local.RoomManager
import com.dust.exchat.framework.local.UserDao
import com.dust.exchat.utils.Constants
import com.dust.exchat.utils.PrefHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideRoomManager(@ApplicationContext context: Context):RoomManager{
        return Room.databaseBuilder(context,RoomManager::class.java,Constants.LocalDbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideUserDao(roomManager: RoomManager):UserDao{
        return roomManager.getUserDao()
    }

    @Singleton
    @Provides
    fun providePrefHandler(@ApplicationContext context: Context):PrefHandler{
        return PrefHandler(context)
    }
}