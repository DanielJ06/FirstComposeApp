package com.example.first.compose.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

data class Message(val author: String, val content: String)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { msg ->
            MessageCard(msg = msg)
        }
    }
}

@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier.padding(all = 8.dp)) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.purple_500))
                .border(1.dp, color = colorResource(id = R.color.white), shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.width(3.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    text = msg.content,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(all = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MessageCardPreview() {
    FirstComposeAppTheme {
        MessageCard(
            msg = Message("Daniel J", "Compose is cool!")
        )
    }
}