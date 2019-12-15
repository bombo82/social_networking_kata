package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.user_interface.UserInterface

class Hello(userInterface: UserInterface) {

    init {
        userInterface.write(greetings())
    }

    fun greetings() = "Hello World!"

}
