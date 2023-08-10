pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Hearthstone Info"
include(":app")
include(":domain")
include(":data")
include(":core")
