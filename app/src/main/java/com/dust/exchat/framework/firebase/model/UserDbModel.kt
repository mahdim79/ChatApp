package com.dust.exchat.framework.firebase.model

data class UserDbModel(
    val uid: String = "",
    val userName: String = "",
    val email: String = "",
    val profilePic: String = "",
    val phoneNumber: String = ""
)