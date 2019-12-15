package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.user_interface.iConsole

class SocialNetworking(private val iConsole: iConsole) {

    fun commandLoop() {
        do {
            val read = iConsole.read()
            iConsole.writeLine(read)
        } while (read != "QUIT")

        iConsole.writeLine("Bye")
    }

}
