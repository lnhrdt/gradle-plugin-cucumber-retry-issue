package com.example

import kotlin.test.Test
import kotlin.test.assertTrue

class FailTest {
    @Test
    fun alwaysFail() {
        assertTrue("batman".isBlank())
    }
}
