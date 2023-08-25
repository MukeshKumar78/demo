plugins {
    id("java")
    checkstyle
}

group = "org.example"
version = "1.0-SNAPSHOT"

checkstyle {
    toolVersion = "10.12.2"
    configFile = file("config/checkstyle/google_checks.xml")
    isIgnoreFailures = true

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