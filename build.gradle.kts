@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove when updating to Gradle 8.1 (https://github.com/gradle/gradle/issues/22797)
plugins {
    alias(libs.plugins.gradle.versions)
    alias(libs.plugins.version.catalog.update)
}

apply("${project.rootDir}/buildscripts/toml-updater-config.gradle")
