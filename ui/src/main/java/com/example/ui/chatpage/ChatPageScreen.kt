package com.example.ui.chatpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ui.R
import com.example.ui.components.ChatScreenHeader
import com.example.ui.components.ChatTextFieldWithSendButton
import com.example.ui.components.MessageItem
import com.example.ui.viewmodel.ChatPageViewModel

@Composable
fun ChatPageScreen() {
    val chatViewModel: ChatPageViewModel = viewModel()
    val messages by chatViewModel.messages.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 70.dp, start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        ChatScreenHeader("Mohammed", {}, {})
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(items = messages) {
                MessageItem(
                    text = it.content, time = "11:00", myMessage = true, image = painterResource(
                        id = R.drawable.my_avatar
                    )
                )
            }
        }

        ChatTextFieldWithSendButton(onSendClicked = {
            chatViewModel.sendMessage(it)

        })
    }
}