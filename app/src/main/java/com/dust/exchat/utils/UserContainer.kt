package com.dust.exchat.utils

import com.dust.core.model.User

object UserContainer {
    private var user:User? = null

    fun updateUser(user: User?){
        this.user = user
    }
}