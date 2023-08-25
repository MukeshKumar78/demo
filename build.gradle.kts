plugins {
    id("java")
    checkstyle
}

val checkStyleVersion by extra("10.12.2")
val googleCheckStylePath by extra("config/checkstyle/google_checks.xml")

group = "org.example"
version = "1.0-SNAPSHOT"

/**
 *  To create jar file. Location will be build/libs/jar_file.jar
 *
 **/
tasks.jar {
    manifest {
        attributes["Main-Class"] = "org.example.Main"
    }
    from(sourceSets.main.get().output)
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