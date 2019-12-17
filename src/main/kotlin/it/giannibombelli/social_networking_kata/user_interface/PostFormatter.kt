package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.domain.Post
import it.giannibombelli.social_networking_kata.iClock

interface iPostFormatter {
    fun format(post: Post): String
}

class PostFormatter(private val clock: iClock) : iPostFormatter {

    override fun format(post: Post): String {
        TODO("not implemented")
    }

}