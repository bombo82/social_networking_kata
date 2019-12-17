package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.iClock
import it.giannibombelli.social_networking_kata.repository.Repository
import it.giannibombelli.social_networking_kata.user_interface.iUserInterface

class SocialNetworkingCommandFactory(
        private val userRepository: Repository<User>,
        private val userInterface: iUserInterface,
        private val clock: iClock
) : CommandFactory {

    val POST_COMMAND_PATTERN = Regex(".*\\s->\\s.*")
    val QUIT_COMMAND_PATTERN = Regex("QUIT")

    override fun commandFor(userCommand: String): Command {
        return when {
            POST_COMMAND_PATTERN.matches(userCommand) -> PostCommand(userCommand, userRepository, clock)
            QUIT_COMMAND_PATTERN.matches(userCommand) -> QuitCommand(userInterface)
            else -> ReadTimelineCommand(userCommand, userRepository, userInterface)
        }
    }
}
