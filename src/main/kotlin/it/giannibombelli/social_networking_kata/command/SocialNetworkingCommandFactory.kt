package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.repository.Repository

class SocialNetworkingCommandFactory(private val userRepository: Repository<User>) : CommandFactory {

    override fun commandFor(userCommand: String): Command {
        return PostCommand(userCommand, userRepository)
    }
}
