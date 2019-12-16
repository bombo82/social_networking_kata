package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.command.Command
import it.giannibombelli.social_networking_kata.command.CommandFactory

interface iCommandExecutor {
    fun execute(userCommand: String): Command
}

class CommandExecutor(private val commandFactory: CommandFactory) : iCommandExecutor {
    override fun execute(userCommand: String): Command {
        val command = commandFactory.commandFor(userCommand)
        command.execute()
        return command
    }

}
