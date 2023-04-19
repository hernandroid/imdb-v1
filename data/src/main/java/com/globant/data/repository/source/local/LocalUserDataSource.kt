package com.globant.data.repository.source.local

import com.globant.domain.model.User

interface LocalUserDataSource {

    suspend fun getUserByEmail(
        email: String
    ) : User

}