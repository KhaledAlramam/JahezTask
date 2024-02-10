package com.example.jaheztask

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jaheztask.ui.theme.JahezTaskTheme
import com.example.ui.chatpage.ChatPageScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JahezTaskTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    ChatPageScreen()
                }
            }
        }
    }
}