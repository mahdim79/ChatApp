package com.dust.core.data.local

import com.dust.core.model.User

interface LocalDataSource {
    suspend fun setUser(user: User):Long
}