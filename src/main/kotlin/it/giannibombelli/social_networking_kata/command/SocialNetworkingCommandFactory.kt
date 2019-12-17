package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.domain.User
import it.giannibombelli.social_networking_kata.IClock
import it.giannibombelli.social_networking_kata.repository.Repository
import it.giannibombelli.social_networking_kata.user_interface.IUserInterface

class SocialNetworkingCommandFactory(
        private val userRepository: Repository<User>,
        private val userInterface: IUserInterface,
        private val clock: IClock
) : CommandFactory {

    private val POST_COMMAND_PATTERN = Regex(".*\\s->\\s.*")
    private val QUIT_COMMAND_PATTERN = Regex("QUIT")

    override fun commandFor(userCommand: String): Command {
        return when {
            POST_COMMAND_PATTERN.matches(userCommand) -> PostCommand(userCommand, userRepository, clock)
            QUIT_COMMAND_PATTERN.matches(userCommand) -> QuitCommand(userInterface)
            else -> ReadTimelineCommand(userCommand, userRepository, userInterface)
        }
    }
}
