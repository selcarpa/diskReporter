import org.jetbrains.kotlin.gradle.plugin.mpp.Executable
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

val ktor_version: String by project
val kotlin_version: String by project
val kotlin_logging_version: String by project
val okio_version: String by project
val taskGroupName = "diskReporter"
plugins {
    kotlin("multiplatform") version "1.9.21"
    id("io.ktor.plugin") version "2.3.6"
    kotlin("plugin.serialization") version "1.9.21"
}

group = "one.tain"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}



kotlin {
    applyDefaultHierarchyTemplate()
    fun KotlinNativeTarget.config(custom: Executable.() -> Unit = {}) {
        binaries {
            executable {
                entryPoint = "main"
                custom()
            }
        }
    }

    mingwX64 {
        config()
    }

    sourceSets{
        val commonMain by getting {
            dependencies{
                implementation("io.ktor:ktor-client-core:$ktor_version")
                implementation("io.ktor:ktor-client-content-negotiation:$ktor_version")
                implementation("io.ktor:ktor-serialization-kotlinx-json:$ktor_version")
                implementation("io.ktor:ktor-client-logging:$ktor_version")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")
                implementation("com.squareup.okio:okio:$okio_version")
                implementation("net.mamoe.yamlkt:yamlkt:0.13.0")
                implementation("net.peanuuutz.tomlkt:tomlkt:0.3.7")
                implementation("io.github.oshai:kotlin-logging:$kotlin_logging_version")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")
            }
        }
    }

}
