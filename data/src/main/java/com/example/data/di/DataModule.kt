package com.example.data.di

import com.example.data.repo.RemoteDataSource
import com.example.data.repo.WebSocketMessageRepository
import com.example.domain.repo.MessageRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    fun provideRemoteDataSource(): RemoteDataSource {
        val serverUri = "wss://socketsbay.com/wss/v2/10/fe33aa550c5f6a01952b338e4e96422f/"
        return RemoteDataSource(serverUri)
    }

}

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWebSocketRepository(repository: WebSocketMessageRepository): MessageRepository
}