package com.globant.data.local.injection

import com.globant.data.local.source.LocalUserDataSourceImpl
import com.globant.data.repository.source.local.LocalUserDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalDataSourceModule {

    @Binds
    abstract fun bindUserDataSource(
        userDataSourceImpl: LocalUserDataSourceImpl
    ) : LocalUserDataSource

}