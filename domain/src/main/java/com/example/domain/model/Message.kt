package com.example.domain.model

data class Message(
    val content: String,
    val owner: Boolean = false
)