package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.user_interface.Console
import it.giannibombelli.social_networking_kata.user_interface.UserInterface

fun main(args: Array<String>) {
    val userInterface: UserInterface = Console()
    Hello(userInterface)
}
