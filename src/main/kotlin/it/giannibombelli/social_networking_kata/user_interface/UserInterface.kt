package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.domain.Post

interface IUserInterface {
    fun display(posts: List<Post>)
    fun display(message: String)
    fun input(): String
}

class UserInterface(private val console: IConsole, private val postFormatter: IPostFormatter) : IUserInterface {

    init {
        console.writeLine(SHORT_NOTICE)
    }

    override fun display(posts: List<Post>) {
        posts.asReversed().forEach {
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

        const val SHORT_NOTICE = """
Social Networking Kata is an implementation of the kata created bySandro Mancuso e Samir Talwar.
Original idea available at this link: https://monospacedmonologues.com/2013/04/the-social-networking-kata/

Copyright (C) 2019 Gianni Bombelli <bombo82@giannibombelli.it>
This program comes with ABSOLUTELY NO WARRANTY; for details see https://www.gnu.org/licenses/gpl-3.0.en.html.
This is free software, and you are welcome to redistribute it under certain conditions;
for details see https://www.gnu.org/licenses/gpl-3.0.en.html.
"""

    }
}