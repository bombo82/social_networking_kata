package it.giannibombelli.social_networking_kata.user_interface

import com.nhaarman.mockitokotlin2.*
import it.giannibombelli.social_networking_kata.domain.Post
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class UserInterfaceShould {

    @Test
    fun printFormattedPosts() {
        val console = mock<iConsole>()
        val postFormatter = mock<iPostFormatter>()
        whenever(postFormatter.format(any<Post>()))
                .thenReturn("Hello")
                .thenReturn("My name is Bombo")

        val userInterface = UserInterface(console, postFormatter)
        userInterface.display(listOf(Post("Hello"), Post("My name is Bombo")))

        inOrder(console) {
            verify(console).writeLine("${UserInterface.PROMPT}Hello")
            verify(console).writeLine("${UserInterface.PROMPT}My name is Bombo")
        }
    }

    @Test
    fun displayMessage() {
        val console = mock<iConsole>()
        val postFormatter = mock<iPostFormatter>()

        val userInterface = UserInterface(console, postFormatter)
        userInterface.display("Bye Bye")

        verify(console).writeLine("${UserInterface.PROMPT}Bye Bye")
    }

    @Test
    fun printConsolePrompt() {
        val console = mock<iConsole>()
        val postFormatter = mock<iPostFormatter>()

        UserInterface(console, postFormatter).input()
        verify(console).write(UserInterface.PROMPT)
    }

    @Test
    fun readConsoleInput() {
        val console = mock<iConsole>()
        whenever(console.read())
                .thenReturn("Ciao Bombo")
        val postFormatter = mock<iPostFormatter>()
        val userInterface = UserInterface(console, postFormatter)

        assertEquals("Ciao Bombo", userInterface.input())
    }
}