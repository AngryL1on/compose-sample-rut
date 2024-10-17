package dev.angryl1on.composesample.models

import kotlinx.serialization.Serializable

/**
 * Data class representing a user with name, email, and password fields.
 *
 * @property [name] The name of the user.
 * @property [email] The email address of the user.
 * @property [password] The password associated with the user's account.
 */
@Serializable
data class User (
    val name: String,
    val email: String,
    val password: String
)

@Serializable
data class LoginCredentials(
    val email: String,
    val password: String
)
