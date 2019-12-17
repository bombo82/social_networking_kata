package it.giannibombelli.social_networking_kata.user_interface

import com.nhaarman.mockitokotlin2.*
import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.IClock
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import kotlin.test.assertEquals

internal class UserInterfaceShould {

    @Test
    fun printFormattedPostsInReverseOrder() {
        val console = mock<IConsole>()
        val postFormatter = mock<IPostFormatter>()
        whenever(postFormatter.format(any()))
                .thenAnswer { (it.getArgument(0) as Post).message }
        val now = LocalDateTime.now()
        val clock = mock<IClock>()
        whenever(clock.now())
                .thenReturn(now)

        val userInterface = UserInterface(console, postFormatter)
        userInterface.display(listOf(
                Post("Hello", now),
                Post("My name is Bombo", now))
        )

        inOrder(console) {
            verify(console).writeLine("${UserInterface.PROMPT}My name is Bombo")
            verify(console).writeLine("${UserInterface.PROMPT}Hello")
        }
    }

    @Test
    fun displayMessage() {
        val console = mock<IConsole>()
        val postFormatter = mock<IPostFormatter>()

        val userInterface = UserInterface(console, postFormatter)
        userInterface.display("Bye Bye")

        verify(console).writeLine("${UserInterface.PROMPT}Bye Bye")
    }

    @Test
    fun printConsolePrompt() {
        val console = mock<IConsole>()
        val postFormatter = mock<IPostFormatter>()

        UserInterface(console, postFormatter).input()
        verify(console).write(UserInterface.PROMPT)
    }

    @Test
    fun readConsoleInput() {
        val console = mock<IConsole>()
        whenever(console.read())
                .thenReturn("Ciao Bombo")
        val postFormatter = mock<IPostFormatter>()
        val userInterface = UserInterface(console, postFormatter)

        assertEquals("Ciao Bombo", userInterface.input())
    }

    @Test
    fun displayShortNotice() {
        val console = mock<IConsole>()
        val postFormatter = mock<IPostFormatter>()

        UserInterface(console, postFormatter)

        verify(console).writeLine(UserInterface.SHORT_NOTICE)
    }
}