import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    maven
    kotlin("jvm") version "1.3.60"
}

group = "com.diegoferreiracaetano"
version = "0.0.72"

repositories {
    mavenCentral()
    jcenter()
    google()
    maven("https://oss.sonatype.org/content/repositories/snapshots")
}

dependencies {
    implementation("com.android.tools.build:gradle:3.5.3")
    implementation("com.github.triplet.gradle:play-publisher:2.8.0-SNAPSHOT")
    implementation(gradleApi())
    implementation(kotlin("stdlib-jdk8"))
    testImplementation("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


tasks {
    getByName<Upload>("uploadArchives") {
        repositories {
            uri(mavenLocal().url)
        }
    }
}