package com.globant.data.repository.injection

import com.globant.data.repository.impl.MovieRepositoryImpl
import com.globant.data.repository.impl.SearchRepositoryImpl
import com.globant.data.repository.impl.UserRepositoryImpl
import com.globant.domain.repository.MovieRepository
import com.globant.domain.repository.SearchRepository
import com.globant.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    abstract fun bindMovieRepository(
        movieRepositoryImpl: MovieRepositoryImpl
    ): MovieRepository

    @Binds
    abstract fun bindSearchRepository(
        searchRepositoryImpl: SearchRepositoryImpl
    ): SearchRepository

    @Binds
    abstract fun bindUserRepository(
        userRepositoryImpl: UserRepositoryImpl
    ): UserRepository

}