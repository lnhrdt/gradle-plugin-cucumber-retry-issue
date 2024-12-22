import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
    alias(libs.plugins.cucumberCompanion)
}

dependencies {
    testImplementation(libs.cucumber.java)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.junit.platformSuiteApi)
    testRuntimeOnly(libs.cucumber.picoContainer)
    testRuntimeOnly(libs.cucumber.junitPlatformEngine)
    testRuntimeOnly(libs.junit.platformSuiteEngine)
}

cucumberCompanion {
    allowEmptySuites = true
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
