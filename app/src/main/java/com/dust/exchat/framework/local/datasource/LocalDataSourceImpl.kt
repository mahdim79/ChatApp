package com.dust.exchat.framework.local.datasource

import com.dust.core.data.local.LocalDataSource
import com.dust.core.model.User
import com.dust.exchat.framework.local.UserDao
import com.dust.exchat.framework.local.entity.UserEntity
import com.dust.exchat.framework.local.mapper.UserLocalMapper
import com.dust.exchat.utils.PrefHandler
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val userDao: UserDao,
    private var userLocalMapper: UserLocalMapper,
    private val prefHandler: PrefHandler
) : LocalDataSource {
    override fun setUser(user: User) {
        prefHandler.setCurrentUser(user)
    }

    override fun getUser(): User? {
        return prefHandler.getCurrentUser()
    }
}