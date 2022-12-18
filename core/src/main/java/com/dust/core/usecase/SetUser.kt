package com.dust.core.usecase

import com.dust.core.data.repo.UserRepository
import com.dust.core.model.User
import com.dust.core.utils.DataStatus
import kotlinx.coroutines.flow.Flow

class SetUser(private val userRepository: UserRepository) {
    operator fun invoke(user: User):Flow<DataStatus<Long>> = userRepository.setUser(user)
}