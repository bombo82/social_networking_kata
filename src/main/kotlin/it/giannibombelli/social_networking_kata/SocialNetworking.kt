package it.giannibombelli.social_networking_kata

import it.giannibombelli.social_networking_kata.user_interface.UserInterface

class SocialNetworking(val userInterface: UserInterface) {

    fun commandLoop() {
        do {
            val read = userInterface.read()
            userInterface.write(read)
        } while (read != "QUIT")

        userInterface.write("Bye")
    }

}
