package dev.angryl1on.composesample.ui.presentation.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import dev.angryl1on.composesample.R
import dev.angryl1on.composesample.ui.presentation.models.UiChat
import dev.angryl1on.composesample.ui.theme.LocalDimensions

@Composable
fun ChatListItem(chat: UiChat) {
    val dimensions = LocalDimensions.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(dimensions.defaultChatListItemPadding),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.user_avatar),
            modifier = Modifier.size(dimensions.defaultAvatarSize)
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = chat.sender,
                    fontWeight = FontWeight.Bold
                )
                Text(text = chat.time)
            }
            Text(text = chat.message)
        }
    }
}

@Composable
@Preview
fun ChatListItemPreview() {
    ChatListItem(
        chat = UiChat(
            sender = "Test",
            message = "Hello",
            time = "12:40"
        )
    )
}
