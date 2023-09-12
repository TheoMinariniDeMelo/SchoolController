plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    implementation(project(":domains"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(group = "io.vavr", name = "vavr", version = "0.10.3")
}

tasks.test {
    useJUnitPlatform()
}