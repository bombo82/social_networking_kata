package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.user_interface.Console
import it.giannibombelli.social_networking_kata.user_interface.iConsole

fun main() {
    val iConsole: iConsole = Console()

    SocialNetworking(iConsole).commandLoop()
}
