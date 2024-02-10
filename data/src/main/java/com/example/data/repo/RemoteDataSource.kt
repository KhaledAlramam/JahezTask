package com.example.data.repo

import android.util.Log
import com.example.domain.model.Message
import com.google.gson.Gson
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.java_websocket.client.WebSocketClient
import org.java_websocket.handshake.ServerHandshake
import java.net.URI
import java.net.URISyntaxException

class RemoteDataSource(private val url: String) {
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages

    private var webSocketClient: WebSocketClient? = null

    init {
        connectWebSocket()
    }

    private fun connectWebSocket() {
        val uri: URI
        try {
            uri = URI(url)
        } catch (e: URISyntaxException) {
            e.printStackTrace()
            return
        }
        webSocketClient = object : WebSocketClient(uri) {
            override fun onOpen(handshakedata: ServerHandshake?) {
                Log.d(TAG, "WebSocket connection opened")
            }

            override fun onClose(code: Int, reason: String?, remote: Boolean) {
                Log.d(TAG, "WebSocket connection closed")
            }

            override fun onMessage(message: String?) {
                Log.d(TAG, "$message")
                message?.let { msg ->
                    val parsedMessage = Gson().fromJson(msg, Message::class.java)
                    _messages.value = _messages.value + parsedMessage
                }
            }

            override fun onError(ex: Exception?) {
                Log.e(TAG, "WebSocket error: ${ex?.message}")
            }
        }

        webSocketClient?.connect()
    }

    fun sendMessage(message: Message) {
        webSocketClient?.send(message.content)
        _messages.value = _messages.value + message

    }

    fun disconnect() {
        webSocketClient?.close()
    }

    companion object {
        private const val TAG = "WebSocketRepository"
    }
}
