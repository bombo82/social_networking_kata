package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.user_interface.iUserInterface

class QuitCommand(private val userInterface: iUserInterface) : Command {

    override fun execute() {
        userInterface.display("Bye")
    }

}
