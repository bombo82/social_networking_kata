package it.giannibombelli.social_networking_kata.command

class SocialNetworkingCommandFactory : CommandFactory {
    override fun commandFor(userCommand: String): Command {
        return PostCommand()
    }
}