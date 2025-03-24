package com.example

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SomeFailTest {
    @Test
    fun test1Pass() {
    }

    @Test
    fun test2Fail() {
        assertTrue("batman".isBlank())
    }
}
