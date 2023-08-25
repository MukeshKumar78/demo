plugins {
    id("java")
    checkstyle
    application
}

val checkStyleVersion by extra("10.12.2")
val googleCheckStylePath by extra("config/checkstyle/google_checks.xml")
val mainClassPath by extra("org.example.Main")

group = "org.example"
version = "1.0-SNAPSHOT"

/**
 *  Assembles a jar archive containing the classes of the 'main' feature.
 *  Location will be build/libs/jar_file.jar
 *
 **/
tasks.jar {
    manifest {
        attributes["Main-Class"] = mainClassPath
    }
    from(sourceSets.main.get().output)
}


/**
 *  Define run task for gradle.
 *  Runs this project as a JVM application
 *
 **/
application {
    mainClass = mainClassPath
}


checkstyle {
    toolVersion = checkStyleVersion
    configFile = file(googleCheckStylePath)
    isIgnoreFailures = false
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.0")
}

tasks.test {
    useJUnitPlatform()
}