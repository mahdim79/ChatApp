package com.dust.exchat.framework.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dust.exchat.utils.Constants

@Entity(tableName = Constants.LocalDbTableName)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,
    var userName:String,
    var profilePic:String,
    var phoneNumber:String
)
