package it.giannibombelli.social_networking_kata.acceptance

import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.CommandExecutor
import it.giannibombelli.social_networking_kata.SocialNetworking
import it.giannibombelli.social_networking_kata.command.SocialNetworkingCommandFactory
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object PostFeature : Spek({

    val QUIT_INPUT = "QUIT"

    Feature("Post") {
        val commandFactory = SocialNetworkingCommandFactory()
        val commandExecutor = CommandExecutor(commandFactory)

        Scenario("Bob can view Alice's timeline") {
            val userInterface = mock<UserInterface>()
            val socialNetworking = SocialNetworking(userInterface)
            val post = "I love the weather today"

            Given("Alice posts messages") {
                commandExecutor.execute("Alice -> $post")
            }
            When("Bob reads Alice's messages") {
                whenever(userInterface.read())
                        .thenReturn("Alice")
                        .thenReturn(QUIT_INPUT)
            }
            Then("Alice's messages are displayed") {
                socialNetworking.commandLoop()
                verify(userInterface).write("> $post (5 minutes ago)")
            }
        }

        Scenario("Alice can view Bob's timeline") {
            val userInterface = mock<UserInterface>()
            val socialNetworking = SocialNetworking(userInterface)
            val postList = listOf(
                    "Damn! We lost!",
                    "Good game though."
            )

            Given("Bob posts messages") {
                commandExecutor.execute("Bob -> ${postList[0]}")
                commandExecutor.execute("Bob -> ${postList[1]}")
            }
            When("Alice reads Bob's messages") {
                whenever(userInterface.read())
                        .thenReturn("Bob")
                        .thenReturn(QUIT_INPUT)
            }
            Then("Bob's messages are displayed in reverse order") {
                socialNetworking.commandLoop()
                inOrder(userInterface) {
                    verify(userInterface).write("> ${postList[1]} (1 minute ago)")
                    verify(userInterface).write("> ${postList[0]} (2 minutes ago)")
                }
            }
        }
    }
})
