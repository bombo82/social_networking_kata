package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.repository.UserRepository
import it.giannibombelli.social_networking_kata.user_interface.Console
import it.giannibombelli.social_networking_kata.user_interface.PostFormatter
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SocialNetworkingCommandFactoryShould {

    private val userInterface = UserInterface(Console(), PostFormatter())
    private val commandFactory = SocialNetworkingCommandFactory(UserRepository(), userInterface)

    @Test
    fun create_postCommand() {
        val command = commandFactory.commandFor("Bombo -> Hello")

        assertNotNull(command)
        assertTrue(command is PostCommand)
    }

    @Test
    fun create_readTimelineCommand() {
        val command = commandFactory.commandFor("Bombo")

        assertNotNull(command)
        assertTrue(command is ReadTimelineCommand)
    }

    @Test
    fun create_quitCommand() {
        val command = commandFactory.commandFor("QUIT")

        assertNotNull(command)
        assertTrue(command is QuitCommand)
    }
}
