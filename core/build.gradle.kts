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
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    compileOnly("dev.jorel:commandapi-bukkit-core:10.0.0")
    compileOnly("com.mojang:brigadier:1.0.18")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = project.name
        }
    }
}
