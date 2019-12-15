package it.giannibombelli.social_networking_kata.command

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SocialNetworkingCommandFactoryShould {

    @Test
    fun createPostCommand() {
        val commandFactory = SocialNetworkingCommandFactory()
        val command = commandFactory.commandFor("Bombo -> Hello")

        assertNotNull(command)
        assertTrue(command is PostCommand)
    }
}