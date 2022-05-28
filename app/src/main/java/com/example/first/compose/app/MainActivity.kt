package com.example.first.compose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.first.compose.app.ui.random_composables.Conversation
import com.example.first.compose.app.ui.random_composables.Message

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val dummyMessages = listOf(
                Message("Daniel J", "I'm so tired today bro!\n But I need to keep studying"),
                Message("Daniel J", "I'm so tired today bro!\n But I need to keep studying"),
                Message("Daniel J", "I'm so tired today bro!\n But I need to keep studying"),
                Message("Daniel J", "I'm so tired today bro!\n But I need to keep studying"),
                Message("Daniel J", "I'm so tired today bro!\n But I need to keep studying"),
                Message("Daniel J", "I'm so tired today bro!\n But I need to keep studying"),
                Message("Daniel J", "I'm so tired today bro!\n But I need to keep studying")
            )

            Conversation(messages = dummyMessages)
            
        }
    }
}