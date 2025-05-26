plugins {
    id("java")
}

group = "org.a9"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.cucumber:cucumber-java:7.22.2")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:7.22.2")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.31.0")
    testImplementation("org.junit.platform:junit-platform-suite:1.10.0")
}

tasks.test {
    useJUnitPlatform()
}