package dev.angryl1on.composesample.ui.presentation.models

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import dev.angryl1on.composesample.models.User

/**
 * Data class representing a user with name, email, and password fields.
 *
 * @property [name] The name of the user.
 * @property [email] The email address of the user.
 * @property [password] The password associated with the user's account.
 */
@Immutable
data class UiUser(
    val name: String,
    val email: String,
    val password: String
)

@Stable
fun User.asUiUser(): UiUser =
    UiUser(
        name = this.name,
        email = this.email,
        password = this.password
    )
