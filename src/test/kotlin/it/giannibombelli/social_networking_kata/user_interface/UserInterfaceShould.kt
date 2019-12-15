package it.giannibombelli.social_networking_kata.user_interface

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.domain.Post
import org.junit.jupiter.api.Test

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
            verify(console).writeLine("> Hello")
            verify(console).writeLine("> My name is Bombo")
        }
    }
}