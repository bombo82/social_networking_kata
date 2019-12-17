package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.command.Command
import it.giannibombelli.social_networking_kata.command.QuitCommand
import it.giannibombelli.social_networking_kata.user_interface.ICommandExecutor
import it.giannibombelli.social_networking_kata.user_interface.IUserInterface

class SocialNetworking(private val userInterface: IUserInterface, private val commandExecutor: ICommandExecutor) {

    fun commandLoop(): Command {
        var command: Command?
        do {
            command = commandExecutor.execute(userInterface.input())
        } while (command !is QuitCommand)

        return command
    }

}
