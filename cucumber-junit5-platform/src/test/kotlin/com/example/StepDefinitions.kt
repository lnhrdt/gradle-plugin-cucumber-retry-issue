package com.example

import io.cucumber.java.en.Then
import org.junit.jupiter.api.Assertions.assertTrue

class StepDefinitions {
    @Then("it passes")
    fun pass() {

    }

    @Then("it fails")
    fun fail() {
        assertTrue("batman".isBlank())
    }
}
