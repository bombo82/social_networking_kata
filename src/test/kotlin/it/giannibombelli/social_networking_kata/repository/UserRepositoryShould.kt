package it.giannibombelli.social_networking_kata.repository

import it.giannibombelli.social_networking_kata.domain.User
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class UserRepositoryShould {

    @Test
    fun createAndGet_createNotExistingUser() {
        val userRepository = UserRepository()

        assertEquals(0, userRepository.users.size)

        val user = userRepository.getOrCreate("NotExistingUser")

        assertEquals(1, userRepository.users.size)
        assertEquals(User("NotExistingUser", mutableListOf()), user)
    }

    @Test
    fun createAndGet_getExistingUser() {
        val userRepository = UserRepository()
        userRepository.users.add(User("ExistingUser", mutableListOf()))

        assertEquals(1, userRepository.users.size)
        val user = userRepository.get("ExistingUser")

        assertEquals(1, userRepository.users.size)
        assertEquals(User("ExistingUser", mutableListOf()), user)
    }
}