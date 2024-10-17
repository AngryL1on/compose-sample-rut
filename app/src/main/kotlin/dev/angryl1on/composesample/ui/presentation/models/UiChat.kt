package dev.angryl1on.composesample.ui.presentation.models

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import dev.angryl1on.composesample.models.Chat

/**
 * Represents a chat message with the sender's name, the message content, and the time it was sent.
 *
 * @property [sender] The name of the person who sent the message.
 * @property [message] The content of the chat message.
 * @property [time] The time when the message was sent, in the format of a string.
 */
@Immutable
data class UiChat(
    val sender: String,
    val message: String,
    val time: String
)

/**
 * Function for map data class Chat into UiChat
 */
@Stable
fun Chat.asUIChat(): UiChat =
    UiChat(
        sender = this.sender,
        message = this.message,
        time = this.time
    )
