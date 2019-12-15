package it.giannibombelli.social_networking_kata.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class UserShould {

    @Test
    fun createAndStoreNewPost() {
        val user = User("Bombo", mutableListOf())

        assertEquals(0, user.posts.size)
        user.newPost("Hello")

        assertEquals(1, user.posts.size)
        assertEquals(Post("Hello"), user.posts[0])
    }
}