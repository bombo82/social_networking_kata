package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.domain.Post

interface iPostFormatter {
    fun format(post: Post): String
}

class PostFormatter: iPostFormatter {
    override fun format(post: Post): String {
        TODO("not implemented")
    }
}