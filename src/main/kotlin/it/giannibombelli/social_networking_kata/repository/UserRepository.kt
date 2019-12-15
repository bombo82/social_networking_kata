package it.giannibombelli.social_networking_kata.repository

import it.giannibombelli.social_networking_kata.domain.User

class UserRepository : Repository<User> {
    override fun getOrCreate(userName: String): User {
        TODO("not implemented")
    }

    override fun get(userName: String): User? {
        TODO("not implemented")
    }
}
