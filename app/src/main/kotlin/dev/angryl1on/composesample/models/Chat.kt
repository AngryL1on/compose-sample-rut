package dev.angryl1on.composesample.models

/**
 * Represents a chat message with the sender's name, the message content, and the time it was sent.
 *
 * @property [sender] The name of the person who sent the message.
 * @property [message] The content of the chat message.
 * @property [time] The time when the message was sent, in the format of a string.
 */
data class Chat (
    val sender: String,
    val message: String,
    val time: String
)
