package dev.angryl1on.composesample.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import dev.angryl1on.composesample.R
import dev.angryl1on.composesample.ui.theme.LocalDimensions

@Composable
fun SignInScreen(
    onSignInClick: (String, String) -> Unit,
    onSignUpClick: () -> Unit
) {
    val dimensions = LocalDimensions.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(id = R.string.app_logo),
            modifier = Modifier.size(dimensions.defaultLogoSize)
        )

        Spacer(modifier = Modifier.height(dimensions.verticalXHuge))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                errorMessage = null  // Clear error when user starts typing
            },
            label = { Text(stringResource(id = R.string.email)) },
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage != null
        )

        Spacer(modifier = Modifier.height(dimensions.verticalMedium))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                errorMessage = null  // Clear error when user starts typing
            },
            label = { Text(stringResource(id = R.string.password)) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            isError = errorMessage != null
        )

        Spacer(modifier = Modifier.height(dimensions.verticalSmall))

        // Error message
        errorMessage?.let {
            Text(
                text = it,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(dimensions.verticalMedium))

        Button(
            onClick = {
                when {
                    email.isBlank() -> errorMessage = "Email cannot be empty"
                    !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() -> errorMessage = "Invalid email format"
                    password.isBlank() -> errorMessage = "Password cannot be empty"
                    password.length < 3 -> errorMessage = "Password must be at least 3 characters long"
                    else -> {
                        errorMessage = null
                        onSignInClick(email, password)
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.sign_in))
        }

        Spacer(modifier = Modifier.height(dimensions.verticalMedium))

        Button(
            onClick = onSignUpClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.sign_up))
        }
    }
}

@Composable
@Preview
fun SignInScreenPreview() {
    SignInScreen(
        onSignInClick = { _, _ ->
            // do nothing
        },
        onSignUpClick = {
            // do nothing
        }
    )
}
