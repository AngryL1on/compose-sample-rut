package dev.angryl1on.composesample.repositories

import dev.angryl1on.composesample.models.LoginCredentials
import dev.angryl1on.composesample.models.User

class UserRepository {
    private val users = mutableListOf<User>()

    // Creating a test user
    init {
        users.add(User("Test User", "test@example.com", "password123"))
    }

    fun authenticateUser(credentials: LoginCredentials): User? {
        return users.find { it.email == credentials.email && it.password == credentials.password }
    }

    fun registerUser(user: User) {
        users.add(user)
    }
}