package it.giannibombelli.social_networking_kata

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.command.QuitCommand
import it.giannibombelli.social_networking_kata.user_interface.ICommandExecutor
import it.giannibombelli.social_networking_kata.user_interface.IUserInterface
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

internal class SocialNetworkingShould {

    @Test
    fun exit_onQuitCommand() {
        val commandExecutor = mock<ICommandExecutor>()
        val userInterface = mock<IUserInterface>()
        whenever(userInterface.input())
                .thenReturn("QUIT")
        whenever(commandExecutor.execute("QUIT"))
                .thenReturn(QuitCommand(userInterface))

        val socialNetworking = SocialNetworking(userInterface, commandExecutor)

        assertTrue(socialNetworking.commandLoop() is QuitCommand)
    }
}
