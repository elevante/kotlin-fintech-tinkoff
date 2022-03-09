plugins {
    kotlin("jvm") version "1.5.21"
}

group = "ru.tinkoff"
version = "1.0-SNAPSHOT"



repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.8.0")

    testImplementation("io.mockk:mockk:1.12.3")

}


tasks.test {
    useJUnit()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}
