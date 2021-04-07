plugins {
    java
}

group = "com.github.darul.archive"
version = "1.0-SNAPSHOT"

val javacordVersion by extra("3.3.0")
val gsonVersion by extra("2.8.6")
val slf4jVersion by extra("1.7.30")
val logbackVersion by extra("1.2.3")
val log4jVersion by extra("2.14.1")
val junitVersion by extra("4.12")
val mockitoVersion by extra("3.8.0")

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.javacord:javacord:${javacordVersion}")
    implementation("com.google.code.gson:gson:${gsonVersion}")

    implementation("org.slf4j:slf4j-api:${slf4jVersion}")
    runtimeOnly("ch.qos.logback:logback-classic:${logbackVersion}")
    runtimeOnly("ch.qos.logback:logback-core:${logbackVersion}")
    runtimeOnly("org.apache.logging.log4j:log4j-to-slf4j:${log4jVersion}")

    testImplementation("junit:junit:${junitVersion}")
    testImplementation("org.mockito:mockito-core:${mockitoVersion}")
}
