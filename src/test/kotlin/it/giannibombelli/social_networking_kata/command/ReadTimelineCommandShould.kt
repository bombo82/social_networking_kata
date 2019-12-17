package it.giannibombelli.social_networking_kata.command

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.repository.Repository
import it.giannibombelli.social_networking_kata.user_interface.IUserInterface
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ReadTimelineCommandShould {

    @Test
    fun displayPosts() {
        val userInterface = mock<IUserInterface>()
        val userRepository = mock<Repository<User>>()
        val now = LocalDateTime.now()
        val posts = mutableListOf(Post("Hello", now))
        val user = User("Bombo")
        user.newPost("Hello", now)
        whenever(userRepository.get("Bombo"))
                .thenReturn(user)

        ReadTimelineCommand("Bombo", userRepository, userInterface).execute()

        verify(userInterface).display(posts)
    }

    @Test
    fun displayEmptyList() {
        val userInterface = mock<IUserInterface>()
        val userRepository = mock<Repository<User>>()
        whenever(userRepository.get("Bombo"))
                .thenReturn(null)

        ReadTimelineCommand("Bombo", userRepository, userInterface).execute()

        verify(userInterface).display(listOf())
    }
}