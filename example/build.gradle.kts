import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.4.10"
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.21"
    id("xyz.jpenilla.run-paper") version "3.1.0"
    id("com.gradleup.shadow") version "9.6.1"
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}

repositories {
    mavenCentral()
}

dependencies {
    paperweight.paperDevBundle("26.2.build.+")

    implementation("dev.jorel:commandapi-paper-shade:12.0.0")
    implementation("dev.jorel:commandapi-kotlin-paper:12.0.0")
    implementation(project(":core"))
    implementation(project(":kotlin"))
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
        options.release.set(25)
    }

    compileKotlin {
        compilerOptions.jvmTarget.set(JvmTarget.JVM_25)
    }

    shadowJar {
        duplicatesStrategy = DuplicatesStrategy.INCLUDE

        fun reloc(pkg: String) = relocate(pkg, "net.tedo0627.commandapi-unicode-args-example.dependency.$pkg")

        reloc("dev.jorel")
    }
}
