package com.dust.exchat.framework.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.dust.exchat.framework.local.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertUser(userEntity: UserEntity):Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUser(userEntity: UserEntity):Long
}