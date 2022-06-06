val javaVersion = 17 // Minecraft 1.18 requires Java 17
val extensionsVersion = 3.1

plugins {
    kotlin("jvm") version "1.6.21"
    id("io.papermc.paperweight.userdev") version "1.3.6"
    id("net.minecrell.plugin-yml.bukkit") version "0.5.1"
    id("xyz.jpenilla.run-paper") version "1.0.6"
}

group = "de.dasphiller"
version = "$extensionsVersion"

repositories {
    mavenCentral()
}

dependencies {
    // PaperMC Dependency
    paperDevBundle("1.18.2-R0.1-SNAPSHOT")

    // KSpigot dependency
    implementation("net.axay:kspigot:1.18.2")
    
    //Extensions dependency
    implementation("de.dasphiller.extensions:extensions:$extensionsVersion")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "$javaVersion"
        }
    }
    compileJava {
        options.encoding = "UTF-8"
        options.release.set(javaVersion)
    }
    assemble {
        dependsOn(reobfJar)
    }
}


bukkit {
    name = "Test"
    apiVersion = "1.18"
    authors = listOf(
        "DasPhiller",
    )
    main = "$group.test.Main"
    version = getVersion().toString()
    libraries = listOf(
        "net.axay:kspigot:1.18.2",
        "de.dasphiller.extensions:extensions:$extensionsVersion"
    )
    prefix = "ppL"
}
