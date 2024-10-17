package dev.angryl1on.composesample.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.angryl1on.composesample.models.LoginCredentials
import dev.angryl1on.composesample.repositories.UserRepository
import dev.angryl1on.composesample.ui.presentation.models.UiChat
import dev.angryl1on.composesample.ui.presentation.screens.HomeScreen
import dev.angryl1on.composesample.ui.presentation.screens.OnboardScreen
import dev.angryl1on.composesample.ui.presentation.screens.SignInScreen
import dev.angryl1on.composesample.ui.presentation.screens.SignUpScreen

sealed class Screen(val route: String) {
    data object Onboarding : Screen("onboarding")
    data object SignIn : Screen("signIn")
    data object SignUp : Screen("signUp")
    data object Home : Screen("home")
}

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val userRepository = remember { UserRepository() }

    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.Onboarding.route
    ) {
        composable(Screen.Onboarding.route) {
            OnboardScreen(
                onNextClick = {
                    navController.navigate(Screen.SignIn.route)
                }
            )
        }

        composable(Screen.SignIn.route) {
            SignInScreen(
                onSignInClick = { email, password ->
                    val credentials = LoginCredentials(email, password)
                    val user = userRepository.authenticateUser(credentials)

                    if (user != null) {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.SignIn.route) { inclusive = true }
                        }
                    }
                },
                onSignUpClick = {
                    navController.navigate(Screen.SignUp.route)
                }
            )
        }

        composable(Screen.SignUp.route) {
            SignUpScreen(
                onSignUpClick = { user ->
                    userRepository.registerUser(user)

                    navController.navigate(Screen.SignIn.route) {
                        popUpTo(Screen.SignUp.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                chats = listOf(
                    UiChat("Иван", "Привет, как дела?", "10:00"),
                    UiChat("Мария", "Встречаемся в 6?", "09:45")
                )
            )
        }
    }
}
