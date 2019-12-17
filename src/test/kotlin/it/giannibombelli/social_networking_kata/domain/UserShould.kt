package it.giannibombelli.social_networking_kata.domain

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.IClock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class UserShould {

    @Test
    fun createAndStoreNewPost() {
        val now = LocalDateTime.now()
        val clock = mock<IClock>()
        whenever(clock.now())
                .thenReturn(now)
        val user = User("Bombo", mutableListOf())

        assertEquals(0, user.posts.size)
        user.newPost("Hello", now)

        assertEquals(1, user.posts.size)
        assertEquals(Post("Hello", now), user.posts[0])
    }
}