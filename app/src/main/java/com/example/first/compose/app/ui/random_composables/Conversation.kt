package com.example.first.compose.app.ui.random_composables

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first.compose.app.ui.theme.FirstComposeAppTheme
import com.example.first.compose.app.ui.theme.Purple500

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
    var expanded by remember { mutableStateOf(false) }

    val interpolatedBg by animateColorAsState(
        targetValue = if (expanded) Color.Blue else Color.Yellow,
        animationSpec = tween(
            durationMillis = 250,
            easing = LinearOutSlowInEasing
        )
    )

    Row(modifier = Modifier.padding(all = 8.dp)) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Purple500)
                .border(1.dp, color = MaterialTheme.colors.secondary, shape = CircleShape)
        )

        Spacer(modifier = Modifier.width(8.dp))

        Column {
            Text(text = msg.author, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.width(3.dp))

            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Button(
                    onClick = { expanded = !expanded },
                    colors = ButtonDefaults.buttonColors(interpolatedBg)
                ) {
                    Text(
                        text = msg.content,
                        maxLines = if (expanded) Int.MAX_VALUE else 1,
                        overflow = if (expanded) TextOverflow.Ellipsis else TextOverflow.Visible,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier
                            .padding(all = 4.dp)
                            .animateContentSize(
                                animationSpec = tween(
                                    durationMillis = 250,
                                    easing = LinearOutSlowInEasing
                                )
                            )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MessageCardPreview() {
    FirstComposeAppTheme {
        MessageCard(
            msg = Message("Daniel J", "Compose is cool \n AAAAAA!")
        )
    }
}