package com.globant.domain.repository

import com.globant.domain.model.User

interface UserRepository {

    suspend fun login(
        email: String,
        password: String
    ) : User

}