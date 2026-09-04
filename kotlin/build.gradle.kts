import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.4.10"
    id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("dev.jorel:commandapi-spigot-core:12.0.0")
    compileOnly(project(":core"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(25)
    }

    compileKotlin {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_25)
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = project.name
            artifact(tasks.jar)
        }
    }
}
