package it.giannibombelli.social_networking_kata.acceptance

import com.nhaarman.mockitokotlin2.inOrder
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import it.giannibombelli.social_networking_kata.IClock
import it.giannibombelli.social_networking_kata.SocialNetworking
import it.giannibombelli.social_networking_kata.command.SocialNetworkingCommandFactory
import it.giannibombelli.social_networking_kata.repository.UserRepository
import it.giannibombelli.social_networking_kata.user_interface.CommandExecutor
import it.giannibombelli.social_networking_kata.user_interface.IConsole
import it.giannibombelli.social_networking_kata.user_interface.PostFormatter
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature
import java.time.LocalDateTime

object FollowingFeatureSpec : Spek({

    val QUIT_INPUT = "QUIT"

    Feature("Following") {

        Scenario("Charlie can subscribe to Alice’s and Bob’s timelines, and view an aggregated list of all subscriptions") {
            val clock = mock<IClock>()
            val now = LocalDateTime.now()
            val console = mock<IConsole>()
            val userInterface = UserInterface(console, PostFormatter(clock))
            val commandFactory = SocialNetworkingCommandFactory(UserRepository(), userInterface, clock)
            val commandExecutor = CommandExecutor(commandFactory)
            val socialNetworking = SocialNetworking(userInterface, commandExecutor)

            whenever(clock.now())
                    .thenReturn(now.minusMinutes(5))
                    .thenReturn(now.minusMinutes(2))
                    .thenReturn(now.minusMinutes(1))
                    .thenReturn(now.minusSeconds(15))
                    .thenReturn(now)

            val postList = listOf(
                    "I love the weather today",
                    "Damn! We lost!",
                    "Good game though.",
                    "I'm in New York today! Anyone wants to have a coffee?"
            )

            Given("Alice posts messages") {
                commandExecutor.execute("Alice -> ${postList[0]}")
            }
            Given("Bob posts messages") {
                commandExecutor.execute("Bob -> ${postList[1]}")
                commandExecutor.execute("Bob -> ${postList[2]}")
            }
            Given("Charlie posts messages") {
                commandExecutor.execute("Charlie -> ${postList[3]}")
            }
            Given("Charlie follows Alice and Bob") {
                commandExecutor.execute("Charlie follows Alice")
                commandExecutor.execute("Charlie follows Bob")
            }
            When("Charlie displays his wall") {
                whenever(console.read())
                        .thenReturn("Charlie wall")
                        .thenReturn(QUIT_INPUT)
            }
            Then("Charlies's wall displayes messages in reverse order") {
                socialNetworking.commandLoop()
                inOrder(console) {
                    verify(console).writeLine("> Charlie - ${postList[3]} (15 seconds ago)")
                    verify(console).writeLine("> Bob - ${postList[2]} (1 minute ago)")
                    verify(console).writeLine("> Bob - ${postList[1]} (2 minutes ago)")
                    verify(console).writeLine("> Alice - ${postList[0]} (5 minutes ago)")
                }
            }
        }
    }
})