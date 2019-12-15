package it.giannibombelli.social_networking_kata.user_interface

import it.giannibombelli.social_networking_kata.command.CommandFactory

class CommandExecutor(private val commandFactory: CommandFactory) {
    fun execute(userCommand: String) {
        val command = commandFactory.commandFor(userCommand)
        command.execute()
    }

}
