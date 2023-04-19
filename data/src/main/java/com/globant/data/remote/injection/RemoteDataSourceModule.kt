package com.globant.data.remote.injection

import com.globant.data.remote.source.RemoteMovieDataSourceImpl
import com.globant.data.remote.source.RemoteSearchDataSourceImpl
import com.globant.data.repository.source.remote.RemoteMovieDataSource
import com.globant.data.repository.source.remote.RemoteSearchDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindMovieDataSource(
        movieDataSourceImpl: RemoteMovieDataSourceImpl
    ): RemoteMovieDataSource

    @Binds
    abstract fun bindSearchDataSource(
        searchDataSourceImpl: RemoteSearchDataSourceImpl
    ): RemoteSearchDataSource

}