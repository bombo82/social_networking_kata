package it.giannibombelli.social_networking_kata.domain

import java.time.LocalDateTime

data class User(val name: String) {

    private val _posts = mutableListOf<Post>()
    val posts: List<Post> get() = _posts

    private val _followed = mutableListOf<String>()
    val followed: List<String> get() = _followed

    fun newPost(message: String, time: LocalDateTime) {
        _posts.add(Post(message, time))
    }

    fun addFollowedUser(followedUser: String) {
        _followed.add(followedUser)
    }
}
