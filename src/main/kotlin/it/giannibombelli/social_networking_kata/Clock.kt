package it.giannibombelli.social_networking_kata

import java.time.LocalDateTime

interface IClock {
    fun now(): LocalDateTime
}

class Clock : IClock {

    override fun now(): LocalDateTime {
        return LocalDateTime.now()
    }

}
