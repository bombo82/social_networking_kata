package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.IClock
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

interface IPostFormatter {
    fun format(post: Post): String
}

class PostFormatter(private val clock: IClock) : IPostFormatter {

    override fun format(post: Post): String {
        return "${post.message} (${formatElapsedTime(post.dateTime)})"
    }

    private fun formatElapsedTime(postDateTime: LocalDateTime): String {
        val now = clock.now()
        val timeUnit = timeUnits.find { it.first.between(postDateTime, now) > 0 } ?: return "now"
        val amount = timeUnit.first.between(postDateTime, now)
        return "$amount ${timeUnit.second}${plural(amount)} ago"
    }

    private fun plural(amount: Long): String {
        return if (amount > 1) "s" else ""
    }

    private val timeUnits = listOf(
            Pair(ChronoUnit.DAYS, "day"),
            Pair(ChronoUnit.HOURS, "hour"),
            Pair(ChronoUnit.MINUTES, "minute"),
            Pair(ChronoUnit.SECONDS, "second")
    )

}
