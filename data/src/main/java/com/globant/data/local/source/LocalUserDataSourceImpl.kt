package com.globant.data.local.source

import com.globant.data.local.db.user.UserDao
import com.globant.data.local.db.user.UserEntity
import com.globant.data.repository.source.local.LocalUserDataSource
import com.globant.domain.model.User
import javax.inject.Inject

class LocalUserDataSourceImpl @Inject constructor(
    private val userDao: UserDao
) : LocalUserDataSource {

    override suspend fun getUserByEmail(email: String): User =
        convert(userDao.getUserByEmail(email))

    private fun convert(userEntity: UserEntity) =
        User(
            id = userEntity.id,
            name = userEntity.name,
            email = userEntity.email,
            password = userEntity.password
        )

}