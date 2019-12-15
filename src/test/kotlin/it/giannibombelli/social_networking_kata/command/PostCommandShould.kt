package it.giannibombelli.social_networking_kata.command

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.repository.Repository
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class PostCommandShould {

    @Test
    fun addNewPostToUser() {
        val user = User("Bombo", mutableListOf())
        val userRepository = mock<Repository<User>>()
        whenever(userRepository.getOrCreate("Bombo"))
                .thenReturn(user)
        PostCommand("Bombo -> Hello", userRepository).execute()

        assertEquals(1, user.posts.size)
        assertEquals(listOf(Post("Hello")), user.posts)
    }
}