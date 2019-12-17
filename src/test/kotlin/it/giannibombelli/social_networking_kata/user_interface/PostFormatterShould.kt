package it.giannibombelli.social_networking_kata.user_interface

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.iClock
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class PostFormatterShould {

    @Test
    fun postMessageWithElapsedTime() {
        val now = LocalDateTime.now()
        val clock = mock<iClock>()
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

        assertEquals("Hello Uncle (1 second)", postFormatter.format(posts[0]))
        assertEquals("Hello Uncle (5 seconds)", postFormatter.format(posts[1]))
        assertEquals("Hello Uncle (1 minute)", postFormatter.format(posts[2]))
        assertEquals("Hello Uncle (10 minutes)", postFormatter.format(posts[3]))
        assertEquals("Hello Uncle (1 hour)", postFormatter.format(posts[4]))
        assertEquals("Hello Uncle (10 hours)", postFormatter.format(posts[5]))
        assertEquals("Hello Uncle (1 day)", postFormatter.format(posts[6]))
        assertEquals("Hello Uncle (20 days)", postFormatter.format(posts[7]))
    }
}