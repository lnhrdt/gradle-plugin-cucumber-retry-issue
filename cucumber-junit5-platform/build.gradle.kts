import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
}

dependencies {
    testImplementation(libs.cucumber.java)
    testImplementation(libs.cucumber.junitPlatformEngine)
    testImplementation(libs.junit.jupiterApi)
    testImplementation(libs.junit.platformSuiteApi)
    testRuntimeOnly(libs.junit.platformSuiteEngine)
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
