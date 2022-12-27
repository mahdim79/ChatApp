package com.dust.core.data.repo

import com.dust.core.data.local.LocalDataSource
import com.dust.core.model.User
import com.dust.core.utils.DataStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(private val localDataSource: LocalDataSource) {
    fun setUser(user: User){
        localDataSource.setUser(user)
    }
    fun getUser():User? = localDataSource.getUser()

}