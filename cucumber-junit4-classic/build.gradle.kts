import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
}

dependencies {
    testImplementation(libs.cucumber.java)
    testImplementation(libs.cucumber.junit4)
}

tasks.withType<Test> {
    useJUnit()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.FAILED)
    }
    retry {
        maxRetries = 1
    }
}
