package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.repository.UserRepository
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class SocialNetworkingCommandFactoryShould {

    @Test
    fun createPostCommand() {
        val commandFactory = SocialNetworkingCommandFactory(UserRepository())
        val command = commandFactory.commandFor("Bombo -> Hello")

        assertNotNull(command)
        assertTrue(command is PostCommand)
    }

}
