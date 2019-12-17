package it.giannibombelli.social_networking_kata.command

import it.giannibombelli.social_networking_kata.user_interface.IUserInterface

class QuitCommand(private val userInterface: IUserInterface) : Command {

    override fun execute() {
        userInterface.display("Bye")
    }

}
