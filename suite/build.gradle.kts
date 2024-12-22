import org.gradle.api.tasks.testing.logging.TestLogEvent

plugins {
    alias(libs.plugins.kotlinJvm)
    alias(libs.plugins.testRetry)
    `jvm-test-suite`
}

dependencies {
    testImplementation(libs.kotlin.test)
    testImplementation(libs.junit.platformSuiteApi)
    testRuntimeOnly(libs.junit.platformSuiteEngine)
}

testing {
    suites {
        @Suppress("UnstableApiUsage")
        named<JvmTestSuite>("test") {
            targets {
                all {
                    testTask {
                        useJUnitPlatform()
                        testLogging {
                            events(TestLogEvent.PASSED, TestLogEvent.FAILED)
                        }
                        retry {
                            maxRetries = 1
                        }
                    }
                }
            }
        }
    }
}
