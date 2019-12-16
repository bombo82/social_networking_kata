package it.giannibombelli.social_networking_kata.acceptance

import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.SocialNetworking
import it.giannibombelli.social_networking_kata.command.SocialNetworkingCommandFactory
import it.giannibombelli.social_networking_kata.repository.UserRepository
import it.giannibombelli.social_networking_kata.user_interface.CommandExecutor
import it.giannibombelli.social_networking_kata.user_interface.PostFormatter
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import it.giannibombelli.social_networking_kata.user_interface.iConsole
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object PostFeature : Spek({

    val QUIT_INPUT = "QUIT"

    Feature("Post") {
        val console = mock<iConsole>()
        val userInterface = UserInterface(console, PostFormatter())
        val commandFactory = SocialNetworkingCommandFactory(UserRepository(), userInterface)
        val commandExecutor = CommandExecutor(commandFactory)
        val socialNetworking = SocialNetworking(userInterface, commandExecutor)

        Scenario("Bob can view Alice's timeline") {
            val post = "I love the weather today"

            Given("Alice posts messages") {
                commandExecutor.execute("Alice -> $post")
            }
            When("Bob reads Alice's messages") {
                whenever(console.read())
                        .thenReturn("Alice")
                        .thenReturn(QUIT_INPUT)
            }
            Then("Alice's messages are displayed") {
                socialNetworking.commandLoop()
                verify(console).writeLine("> $post (5 minutes ago)")
            }
        }

        Scenario("Alice can view Bob's timeline") {
            val postList = listOf(
                    "Damn! We lost!",
                    "Good game though."
            )

            Given("Bob posts messages") {
                commandExecutor.execute("Bob -> ${postList[0]}")
                commandExecutor.execute("Bob -> ${postList[1]}")
            }
            When("Alice reads Bob's messages") {
                whenever(console.read())
                        .thenReturn("Bob")
                        .thenReturn(QUIT_INPUT)
            }
            Then("Bob's messages are displayed in reverse order") {
                socialNetworking.commandLoop()
                inOrder(console) {
                    verify(console).writeLine("> ${postList[1]} (1 minute ago)")
                    verify(console).writeLine("> ${postList[0]} (2 minutes ago)")
                }
            }
        }
    }
})
