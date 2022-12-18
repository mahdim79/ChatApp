package com.dust.core.data.repo

import com.dust.core.data.local.LocalDataSource
import com.dust.core.model.User
import com.dust.core.utils.DataStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserRepository(private val localDataSource: LocalDataSource) {
    fun setUser(user: User):Flow<DataStatus<Long>>{
        return flow {
            try {
                emit(DataStatus.Success(localDataSource.setUser(user)))
            }catch (e:Exception){
                emit(DataStatus.Error(e.message ?: "unknownError"))
            }
        }
    }
}