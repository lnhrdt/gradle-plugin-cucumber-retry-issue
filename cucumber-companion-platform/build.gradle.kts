import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
    alias(libs.plugins.cucumberCompanion)
}

dependencies {
    testImplementation(project(":shared"))
    testImplementation(libs.cucumber.java)
    testImplementation(libs.junit.jupiterApi)
    testImplementation(libs.junit.platformSuiteApi)
    testRuntimeOnly(libs.cucumber.junitPlatformEngine)
    testRuntimeOnly(libs.junit.platformSuiteEngine)
}

cucumberCompanion {
    allowEmptySuites = true
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
