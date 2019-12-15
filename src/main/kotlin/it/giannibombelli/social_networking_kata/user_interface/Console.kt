package it.giannibombelli.social_networking_kata.user_interface

class Console : UserInterface {

    override fun write(message: String) {
        println(message)
    }

    override fun read(): String {
        return readLine() ?: ""
    }

}
