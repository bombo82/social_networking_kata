package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.domain.Post

interface iUserInterface {
    fun display(posts: List<Post>)
    fun display(message: String)
    fun input(): String
}

class UserInterface(private val console: iConsole, private val postFormatter: iPostFormatter) : iUserInterface {

    override fun display(posts: List<Post>) {
        posts.forEach {
            val message = postFormatter.format(it)
            console.writeLine("$PROMPT$message")
        }
    }

    override fun display(message: String) {
        console.writeLine("$PROMPT$message")
    }

    override fun input(): String {
        console.write(PROMPT)
        return console.read()
    }

    companion object {
        const val PROMPT = "> "
    }
}