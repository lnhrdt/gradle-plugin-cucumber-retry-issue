import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
}

dependencies {
    testImplementation(project(":shared"))
    testImplementation(libs.junit.junit4)
    testRuntimeOnly(libs.junit.vintageEngine)
}

tasks.withType<Test> {
    useJUnitPlatform()
    maxParallelForks = Runtime.getRuntime().availableProcessors()
    forkEvery = 1
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.FAILED)
        showStandardStreams = true
    }
    retry {
        maxRetries = 1
    }
}
