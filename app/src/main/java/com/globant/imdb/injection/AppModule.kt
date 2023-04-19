package com.globant.imdb.injection

import com.globant.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideUseCaseConfiguration() = UseCase.Configuration(Dispatchers.IO)

}