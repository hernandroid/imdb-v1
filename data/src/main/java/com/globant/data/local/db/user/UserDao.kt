package com.globant.data.local.db.user

import androidx.room.Dao
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT id, name, email, password FROM user WHERE email = :email")
    suspend fun getUserByEmail(email: String): UserEntity

}