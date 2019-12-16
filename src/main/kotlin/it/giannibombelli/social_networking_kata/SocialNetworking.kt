package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.command.Command
import it.giannibombelli.social_networking_kata.command.QuitCommand
import it.giannibombelli.social_networking_kata.user_interface.iCommandExecutor
import it.giannibombelli.social_networking_kata.user_interface.iUserInterface

class SocialNetworking(private val userInterface: iUserInterface, private val commandExecutor: iCommandExecutor) {

    fun commandLoop(): Command {
        var command: Command?
        do {
            command = commandExecutor.execute(userInterface.input())
        } while (command !is QuitCommand)

        return command
    }

}
