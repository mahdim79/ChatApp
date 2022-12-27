package com.dust.core.usecase

import com.dust.core.data.repo.UserRepository
import com.dust.core.model.User

class GetUser(private val userRepository: UserRepository) {
    operator fun invoke():User? = userRepository.getUser()
}