import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
}

dependencies {
    testImplementation(project(":shared"))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platformSuiteEngine)
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("junit.jupiter.execution.parallel.enabled", "true")
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
    systemProperty("junit.jupiter.execution.parallel.mode.classes.default", "concurrent")
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.FAILED)
        showStandardStreams = true
    }
    retry {
        maxRetries = 1
    }
}
