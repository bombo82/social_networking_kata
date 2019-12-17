package it.giannibombelli.social_networking_kata.repository

import it.giannibombelli.social_networking_kata.domain.User

class UserRepository : Repository<User> {
    val users = mutableListOf<User>()

    override fun getOrCreate(userName: String): User {
        val user = get(userName)
        if (user == null) {
            val newUser = User(userName)
            users.add(newUser)
            return newUser
        }
        return user
    }

    override fun get(userName: String): User? {
        return users.find { it.name == userName }
    }
}
