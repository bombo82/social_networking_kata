package it.giannibombelli.social_networking_kata

import java.time.LocalDateTime

interface iClock {
    fun now(): LocalDateTime
}

class Clock : iClock {

    override fun now(): LocalDateTime {
        return LocalDateTime.now()
    }

}
