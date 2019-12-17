package it.giannibombelli.social_networking_kata.domain

import java.time.LocalDateTime

data class User(val name: String, val posts: MutableList<Post>) {
    fun newPost(message: String, time: LocalDateTime) {
        posts.add(Post(message, time))
    }
}
