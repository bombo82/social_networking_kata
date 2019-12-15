package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.user_interface.Console
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class HelloTest {

    @Test
    fun greetings() {
        val userInterface: UserInterface = Console()
        val socialNetwork = Hello(userInterface)

        assertEquals("Hello World!", socialNetwork.greetings())
    }
}
