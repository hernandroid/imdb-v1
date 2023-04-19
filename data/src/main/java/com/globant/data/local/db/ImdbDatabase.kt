package com.globant.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.globant.data.local.db.user.UserDao
import com.globant.data.local.db.user.UserEntity

@Database(
    entities = [
        UserEntity::class
    ], version = 1
)
abstract class ImdbDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}