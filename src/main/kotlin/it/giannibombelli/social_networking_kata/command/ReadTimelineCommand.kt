package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.repository.Repository
import it.giannibombelli.social_networking_kata.user_interface.iUserInterface

class ReadTimelineCommand(private val userCommand: String, private val userRepository: Repository<User>, private val userInterface: iUserInterface) : Command {

    override fun execute() {
        val user = userRepository.get(userCommand)
        userInterface.display(user?.posts ?: listOf())
    }

}
