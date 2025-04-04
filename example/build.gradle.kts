plugins {
    kotlin("jvm") version "2.0.21"
    id("io.papermc.paperweight.userdev") version "1.7.7"
    id("xyz.jpenilla.run-paper") version "2.3.1"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(17))
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("1.20.4-R0.1-SNAPSHOT")

    implementation("dev.jorel:commandapi-bukkit-shade:10.0.0")
    implementation("dev.jorel:commandapi-bukkit-kotlin:10.0.0")
    implementation(project(":core"))
    implementation(project(":kotlin"))
}

tasks {
    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(17)
    }

    shadowJar {
        fun reloc(pkg: String) = relocate(pkg, "net.tedo0627.commandapi-unicode-args-example.dependency.$pkg")

        reloc("dev.jorel")
    }
}
