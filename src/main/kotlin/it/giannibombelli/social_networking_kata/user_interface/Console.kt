package it.giannibombelli.social_networking_kata.user_interface

interface IConsole {

    fun write(message: String)

    fun writeLine(message: String)

    fun read(): String

}

class Console : IConsole {

    override fun write(message: String) {
        print(message)
    }

    override fun writeLine(message: String) {
        println(message)
    }

    override fun read(): String {
        return readLine() ?: ""
    }

}
