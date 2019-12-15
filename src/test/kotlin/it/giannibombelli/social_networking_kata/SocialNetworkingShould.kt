package it.giannibombelli.social_networking_kata

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import org.junit.jupiter.api.Test

internal class SocialNetworkingShould {

    @Test
    fun exit_onReadQuit() {
        val userInterface = mock<UserInterface>()
        whenever(userInterface.read())
                .thenReturn("QUIT")

        SocialNetworking(userInterface).commandLoop()
        verify(userInterface).write("Bye")
    }
}
