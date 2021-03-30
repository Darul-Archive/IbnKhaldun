plugins {
    java
}

group = "com.github.spacetastics"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.javacord:javacord:3.1.2")

    runtimeOnly("org.apache.logging.log4j:log4j-core:2.11.0")

    testImplementation("junit:junit:4.12")
}
