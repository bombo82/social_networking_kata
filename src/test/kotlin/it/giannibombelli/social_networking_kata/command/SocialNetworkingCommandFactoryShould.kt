package it.giannibombelli.social_networking_kata.command

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.IClock
import it.giannibombelli.social_networking_kata.repository.UserRepository
import it.giannibombelli.social_networking_kata.user_interface.Console
import it.giannibombelli.social_networking_kata.user_interface.PostFormatter
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class SocialNetworkingCommandFactoryShould {
    private val now = LocalDateTime.now()
    private val clock = mock<IClock>()
    private val userInterface = UserInterface(Console(), PostFormatter(clock))
    private val commandFactory = SocialNetworkingCommandFactory(UserRepository(), userInterface, clock)

    @BeforeEach
    internal fun setUp() {
        whenever(clock.now())
                .thenReturn(now)
    }

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

    @Test
    fun create_followsCommand() {
        val command = commandFactory.commandFor("Bombo follows Bob")

        assertNotNull(command)
        assertTrue(command is FollowsCommand)
    }
}
