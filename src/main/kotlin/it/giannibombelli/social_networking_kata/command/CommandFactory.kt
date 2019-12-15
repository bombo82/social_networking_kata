package it.giannibombelli.social_networking_kata.command

interface CommandFactory {

    fun commandFor(userCommand: String): Command

}
