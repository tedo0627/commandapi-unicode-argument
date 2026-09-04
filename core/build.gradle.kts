plugins {
    id("java")
    id("maven-publish")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    }
    maven {
        url = uri("https://libraries.minecraft.net")
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:26.2-R0.1-SNAPSHOT")
    compileOnly("dev.jorel:commandapi-spigot-core:12.0.0")
    compileOnly("com.mojang:brigadier:1.0.18")
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(25)
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
