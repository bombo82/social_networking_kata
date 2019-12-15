package it.giannibombelli.social_networking_kata

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.user_interface.iConsole
import org.junit.jupiter.api.Test

internal class SocialNetworkingShould {

    @Test
    fun exit_onReadQuit() {
        val console = mock<iConsole>()
        whenever(console.read())
                .thenReturn("QUIT")

        SocialNetworking(console).commandLoop()
        verify(console).writeLine("Bye")
    }
}
