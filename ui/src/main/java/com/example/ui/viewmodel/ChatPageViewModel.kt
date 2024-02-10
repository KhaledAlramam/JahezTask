package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Message
import com.example.domain.repo.MessageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatPageViewModel @Inject constructor(
    private val messageRepository: MessageRepository
) :
    ViewModel() {

    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    init {
        observeMessages()
    }

    fun sendMessage(messageContent: String) {
        val message = Message(messageContent, owner = true)
        messageRepository.sendMessage(message)
    }

    private fun observeMessages() {
        viewModelScope.launch {
            messageRepository.observeMessages().collect { messages ->
                _messages.value = messages
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        messageRepository.disconnect()
    }
}