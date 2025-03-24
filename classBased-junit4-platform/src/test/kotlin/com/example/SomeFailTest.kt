package com.example

import org.junit.Assert.assertTrue
import org.junit.Test


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
