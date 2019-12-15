package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.repository.Repository

class PostCommand(private val userCommand: String, private val userRepository: Repository<User>) : Command {

    override fun execute() {
        val (userName, message) = userCommand.split(SEPARATOR)
        val user = userRepository.getOrCreate(userName)
        user.newPost(message)
    }

    companion object {
        const val SEPARATOR = " -> ";
    }

}