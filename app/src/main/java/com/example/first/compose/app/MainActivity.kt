package com.example.first.compose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.first.compose.app.ui.random_composables.Conversation
import com.example.first.compose.app.ui.random_composables.Message
import com.example.first.compose.app.ui.theme.FirstComposeAppTheme

class MainActivity : ComponentActivity() {

    private val mockedConversation = listOf(
        Message("Daniel J", "O que achou do compose?"),
        Message("Daniel R", "As primeiras impressões foram bacanas"),
        Message("Daniel J", "Lembra um pouco o React Native, né?"),
        Message("Daniel R", "Até que lembra sim")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FirstComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Conversation(messages = mockedConversation)
                }
            }
        }
    }
}