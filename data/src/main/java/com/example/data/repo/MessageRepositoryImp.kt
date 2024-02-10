package com.example.data.repo

import com.example.domain.model.Message
import com.example.domain.repo.MessageRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WebSocketMessageRepository @Inject constructor(private val remoteDataSource: RemoteDataSource) :
    MessageRepository {
    override fun observeMessages(): Flow<List<Message>> = remoteDataSource.messages
    override fun sendMessage(message: Message) {
        remoteDataSource.sendMessage(message)
    }

    override fun disconnect() {
        remoteDataSource.disconnect()
    }

}
