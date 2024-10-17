package dev.angryl1on.composesample.ui.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import dev.angryl1on.composesample.ui.presentation.components.home.ChatListItem
import dev.angryl1on.composesample.ui.presentation.models.UiChat

@Composable
fun HomeScreen(chats: List<UiChat>) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Hello, here are your chats",
            fontSize = 18.sp
        )

        LazyColumn {
            items(chats) { chat ->
                ChatListItem(chat)
            }
        }
    }
}

@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(
        chats = listOf(
            UiChat("Alice", "Hi, how are you?", "10:30"),
            UiChat("Bob", "Don't forget the meeting", "09:45"),
            UiChat("Charlie", "Let's catch up!", "08:15")
        )
    )
}
