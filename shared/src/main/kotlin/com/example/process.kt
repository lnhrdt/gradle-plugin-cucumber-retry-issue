package com.example

import java.lang.management.ManagementFactory.getRuntimeMXBean

fun printProcessInfo() {
    val processId = getRuntimeMXBean().name.split("@").first()
    val threadName = Thread.currentThread().name
    val message = "running in process: $processId, thread: $threadName"
    println(message)
}
