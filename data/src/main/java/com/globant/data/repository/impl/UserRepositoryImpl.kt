package com.globant.data.repository.impl

import com.globant.data.repository.source.local.LocalUserDataSource
import com.globant.domain.model.User
import com.globant.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val localUserDataSource: LocalUserDataSource
) : UserRepository {

    override suspend fun login(email: String, password: String): User {
        return localUserDataSource.getUserByEmail(email)
    }

}