package com.dust.exchat.framework.firebase.mapper

import com.dust.core.model.User
import com.dust.exchat.framework.firebase.model.UserDbModel
import javax.inject.Inject

class UserHashMapper @Inject constructor() {

    private val UID_KEY = "uid"
    private val USERNAME_KEY = "userName"
    private val EMAIL_KEY = "email"
    private val PROFILE_PIC_KEY = "profilePic"
    private val PHONE_NUMBER_KEY = "phoneNumber"

    fun userToHashmap(user: User):HashMap<String,Any>{
        val hashMap = HashMap<String,Any>()
        hashMap[UID_KEY] = user.uid
        hashMap[USERNAME_KEY] = user.userName
        hashMap[EMAIL_KEY] = user.email
        hashMap[PROFILE_PIC_KEY] = user.profilePic
        hashMap[PHONE_NUMBER_KEY] = user.phoneNumber
        return hashMap
    }

    fun dbModelToUser(userDb:UserDbModel):User{
        return User(null,userDb.uid,userDb.email,userDb.userName,userDb.profilePic,userDb.phoneNumber)
    }
}