plugins {
    java
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

group = "com.seojun"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        url = uri("https://repo.papermc.io/repository/snapshots/")
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.5-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(21)
}

tasks.register("printRunPaper") {
    doLast {
        println(extensions.getByType<xyz.jpenilla.runpaper.RunPaperPluginExtension>().minecraftVersion.get())
    }
}

extensions.getByType<xyz.jpenilla.runpaper.RunPaperPluginExtension>().minecraftVersion.set("1.21.5")
