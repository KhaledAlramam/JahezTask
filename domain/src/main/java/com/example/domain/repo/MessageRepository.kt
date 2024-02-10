package com.example.domain.repo

import com.example.domain.model.Message
import kotlinx.coroutines.flow.Flow

interface MessageRepository {
    fun sendMessage(message: Message)
    fun observeMessages(): Flow<List<Message>>

    fun disconnect()
}