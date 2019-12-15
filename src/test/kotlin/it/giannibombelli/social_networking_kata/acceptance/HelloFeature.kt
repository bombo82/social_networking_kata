package it.giannibombelli.social_networking_kata.acceptance

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import it.giannibombelli.social_networking_kata.Hello
import it.giannibombelli.social_networking_kata.user_interface.UserInterface
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

object HelloFeature : Spek({

    Feature("Hello") {
        val userInterface: UserInterface = mock()
        val expected = "Hello World!"

        Scenario("print greetings") {
            When("instantiate application") {
                Hello(userInterface)
            }

            Then("it should print \"$expected\"") {
                verify(userInterface).write(expected)
            }
        }
    }
})
