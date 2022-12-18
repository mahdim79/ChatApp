package com.dust.exchat.framework.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dust.exchat.framework.local.entity.UserEntity
import com.dust.exchat.utils.Constants

@Database(entities = [UserEntity::class], version = Constants.LocalDbVersion)
abstract class RoomManager: RoomDatabase() {
    abstract fun getUserDao():UserDao
}