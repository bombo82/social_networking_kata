package it.giannibombelli.social_networking_kata.command

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import it.giannibombelli.social_networking_kata.user_interface.iUserInterface
import org.junit.jupiter.api.Test

internal class QuitCommandShould {

    @Test
    fun displayFarewell() {
        val userInterface = mock<iUserInterface>()

        QuitCommand(userInterface).execute()
        verify(userInterface).display("Bye")
    }
}