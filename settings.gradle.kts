dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

include(":cucumber")
include(":just-junit")
include(":suite")

rootProject.name = "gradle-plugin-cucumber-retry-issue"
