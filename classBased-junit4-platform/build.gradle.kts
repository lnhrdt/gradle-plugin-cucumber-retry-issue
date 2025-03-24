import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
}

dependencies {
    testImplementation(libs.junit.junit4)
    testRuntimeOnly(libs.junit.vintageEngine)
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.FAILED)
    }
    retry {
        maxRetries = 1
    }
}
