package it.giannibombelli.social_networking_kata.command

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.repository.Repository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class FollowsCommandShould {

    @Test
    fun addFollowedToUser() {
        val user = User("Bombo", mutableListOf())
        val userRepository = mock<Repository<User>>()
        whenever(userRepository.getOrCreate("Bombo"))
                .thenReturn(user)

        FollowsCommand("Bombo follows Bob", userRepository).execute()

        assertEquals(1, user.followed.size)
        assertEquals("Bob", user.followed[0])
    }
}
