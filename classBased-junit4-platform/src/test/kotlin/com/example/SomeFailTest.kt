package com.example

import org.junit.Assert.assertTrue
import org.junit.Test


class SomeFailTest {
    @Test
    fun test1Pass() {
    }

    @Test
    fun test2Fail() {
        assertTrue("batman".isBlank())
    }
}
