package it.giannibombelli.social_networking_kata.domain

data class User(val name: String, val posts: MutableList<Post>) {
    fun newPost(message: String) {
        posts.add(Post(message))
    }
}
