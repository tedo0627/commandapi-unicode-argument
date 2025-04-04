plugins {
    kotlin("jvm") version "2.0.21"
    id("maven-publish")
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("dev.jorel:commandapi-bukkit-core:10.0.0")
    compileOnly(project(":core"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = project.name
        }
    }
}
