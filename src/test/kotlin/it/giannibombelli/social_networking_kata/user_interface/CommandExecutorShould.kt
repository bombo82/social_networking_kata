package it.giannibombelli.social_networking_kata.user_interface

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.command.Command
import it.giannibombelli.social_networking_kata.command.CommandFactory
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class CommandExecutorShould {

    @Test
    fun execute_givenCommand() {
        val commandFactory = mock<CommandFactory>()
        val userCommand = "Bombo -> Hello"
        val command = mock<Command>()
        whenever(commandFactory.commandFor(userCommand))
                .thenReturn(command)

        val commandExecutor = CommandExecutor(commandFactory)

        assertEquals(command, commandExecutor.execute(userCommand))
        verify(command).execute()
    }
}