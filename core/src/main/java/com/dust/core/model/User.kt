package com.dust.core.model

data class User(
    var id:Int? = null,
    var uid:String,
    var email:String,
    var userName:String,
    var profilePic:String,
    var phoneNumber:String
)
