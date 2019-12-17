package it.giannibombelli.social_networking_kata.user_interface

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.IClock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class PostFormatterShould {

    @Test
    fun postMessageWithElapsedTime() {
        val now = LocalDateTime.now()
        val clock = mock<IClock>()
        whenever(clock.now())
                .thenReturn(now)
        val postFormatter = PostFormatter(clock)

        val posts = listOf(
                Post("Hello Uncle", now),
                Post("Hello Uncle", now.minusSeconds(1)),
                Post("Hello Uncle", now.minusSeconds(5)),
                Post("Hello Uncle", now.minusMinutes(1)),
                Post("Hello Uncle", now.minusMinutes(10)),
                Post("Hello Uncle", now.minusHours(1)),
                Post("Hello Uncle", now.minusHours(15)),
                Post("Hello Uncle", now.minusDays(1)),
                Post("Hello Uncle", now.minusDays(20))
        )

        assertEquals("Hello Uncle (now)", postFormatter.format(posts[0]))
        assertEquals("Hello Uncle (1 second ago)", postFormatter.format(posts[1]))
        assertEquals("Hello Uncle (5 seconds ago)", postFormatter.format(posts[2]))
        assertEquals("Hello Uncle (1 minute ago)", postFormatter.format(posts[3]))
        assertEquals("Hello Uncle (10 minutes ago)", postFormatter.format(posts[4]))
        assertEquals("Hello Uncle (1 hour ago)", postFormatter.format(posts[5]))
        assertEquals("Hello Uncle (15 hours ago)", postFormatter.format(posts[6]))
        assertEquals("Hello Uncle (1 day ago)", postFormatter.format(posts[7]))
        assertEquals("Hello Uncle (20 days ago)", postFormatter.format(posts[8]))
    }
}