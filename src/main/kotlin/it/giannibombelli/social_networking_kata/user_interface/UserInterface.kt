package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.domain.Post

interface iUserInterface {
    fun display(posts: List<Post>)
}

class UserInterface(private val console: iConsole, private val postFormatter: iPostFormatter) : iUserInterface {

    override fun display(posts: List<Post>) {
        posts.forEach {
            val message = postFormatter.format(it)
            console.writeLine("> $message")}
    }

}