package com.example

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class SomeFailTest {
    @Test
    fun test1Pass() {
        printProcessInfo()
    }

    @Test
    fun test2Fail() {
        printProcessInfo()
        assertTrue("batman".isBlank())
    }
}
