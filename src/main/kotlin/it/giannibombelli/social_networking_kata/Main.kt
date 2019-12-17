package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.command.SocialNetworkingCommandFactory
import it.giannibombelli.social_networking_kata.repository.UserRepository
import it.giannibombelli.social_networking_kata.user_interface.CommandExecutor
import it.giannibombelli.social_networking_kata.user_interface.Console
import it.giannibombelli.social_networking_kata.user_interface.PostFormatter
import it.giannibombelli.social_networking_kata.user_interface.UserInterface

fun main() {
    val clock = Clock()
    val postFormatter = PostFormatter(clock)
    val userInterface = UserInterface(Console(), postFormatter)
    val commandFactory = SocialNetworkingCommandFactory(UserRepository(), userInterface, clock)
    val commandExecutor = CommandExecutor(commandFactory)

    SocialNetworking(userInterface, commandExecutor).commandLoop()
}
