package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.repository.Repository

class FollowsCommand(
        private val userCommand: String,
        private val userRepository: Repository<User>
) : Command {
    override fun execute() {
        val (userName, followedUser) = userCommand.split(SEPARATOR)
        val user = userRepository.getOrCreate(userName)
        user.addFollowedUser(followedUser)
    }

    companion object {
        const val SEPARATOR = " follows "
    }
}
