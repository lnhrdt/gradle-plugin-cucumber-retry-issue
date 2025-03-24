dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

include(":classBased-junit4-classic")
include(":classBased-junit4-platform")
include(":classBased-junit5-platform")
include(":cucumber-companion-platform")
include(":cucumber-junit4-classic")
include(":cucumber-junit4-platform")
include(":cucumber-junit5-platform")

rootProject.name = "gradle-plugin-cucumber-retry-issue"
