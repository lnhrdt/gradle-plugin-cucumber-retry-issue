import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
}

dependencies {
    testImplementation(project(":shared"))
    testImplementation(libs.cucumber.java)
    testImplementation(libs.cucumber.junitPlatformEngine)
    testImplementation(libs.junit.jupiterApi)
    testImplementation(libs.junit.platformSuiteApi)
    testRuntimeOnly(libs.junit.platformSuiteEngine)
}

tasks.withType<Test> {
    useJUnitPlatform()
    systemProperty("cucumber.execution.parallel.enabled", "true")
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.FAILED)
        showStandardStreams = true
    }
    retry {
        maxRetries = 1
    }
}
