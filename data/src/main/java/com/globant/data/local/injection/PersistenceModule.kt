package com.globant.data.local.injection

import android.content.Context
import androidx.room.Room
import com.globant.data.local.db.ImdbDatabase
import com.globant.data.local.db.user.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    fun provideIMDbDatabase(@ApplicationContext context: Context): ImdbDatabase =
        Room.databaseBuilder(
            context,
            ImdbDatabase::class.java, "imdb-database"
        ).build()

    @Provides
    fun provideUserDao(imdbDatabase: ImdbDatabase): UserDao = imdbDatabase.userDao()

}