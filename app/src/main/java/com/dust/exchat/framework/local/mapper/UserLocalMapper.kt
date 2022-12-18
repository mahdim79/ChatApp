package com.dust.exchat.framework.local.mapper

import com.dust.core.model.User
import com.dust.exchat.framework.local.entity.UserEntity
import com.dust.exchat.utils.BaseMapper
import javax.inject.Inject

class UserLocalMapper @Inject constructor():BaseMapper<UserEntity,User> {
    override fun mapToEntity(model: User): UserEntity {
        return UserEntity(model.id,model.userName,model.profilePic,model.phoneNumber)
    }

    override fun mapFromEntity(entity: UserEntity): User {
        return User(entity.id,entity.userName,entity.profilePic,entity.phoneNumber)
    }
}