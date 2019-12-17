package it.giannibombelli.social_networking_kata.command

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.iClock
import it.giannibombelli.social_networking_kata.repository.Repository
import it.giannibombelli.social_networking_kata.user_interface.iUserInterface
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ReadTimelineCommandShould {

    @Test
    fun displayPosts() {
        val now = LocalDateTime.now()
        val clock = mock<iClock>()
        whenever(clock.now())
                .thenReturn(now)
        val posts = mutableListOf(Post("Hello", now))
        val userInterface = mock<iUserInterface>()
        val userRepository = mock<Repository<User>>()
        whenever(userRepository.get("Bombo"))
                .thenReturn(User("Bombo", posts))

        ReadTimelineCommand("Bombo", userRepository, userInterface).execute()

        verify(userInterface).display(posts)
    }

    @Test
    fun displayEmptyList() {
        val userInterface = mock<iUserInterface>()
        val userRepository = mock<Repository<User>>()
        whenever(userRepository.get("Bombo"))
                .thenReturn(null)

        ReadTimelineCommand("Bombo", userRepository, userInterface).execute()

        verify(userInterface).display(listOf())
    }
}