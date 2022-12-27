package com.dust.core.data.local

import com.dust.core.model.User

interface LocalDataSource {
    fun setUser(user: User)
    fun getUser():User?
}