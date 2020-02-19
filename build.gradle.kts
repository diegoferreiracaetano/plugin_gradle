import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    maven
    kotlin("jvm") version "1.3.60"
    id("jacoco")
}

group = "com.diegoferreiracaetano"
version = "0.0.11"


apply {
    from("$rootDir/tools/ktlint.gradle")
    from("$rootDir/tools/base.gradle")
}
repositories {
    mavenCentral()
    jcenter()
}

buildscript {

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }

    dependencies{
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.7")
        classpath("org.jacoco:org.jacoco.core:0.8.5")
    }
}

dependencies {
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