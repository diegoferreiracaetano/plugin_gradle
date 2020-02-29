package com.diegoferreiracaetano.versions

import com.android.build.gradle.AppExtension
import com.diegoferreiracaetano.versions.dependencies.AndroidTestExtension
import com.diegoferreiracaetano.versions.dependencies.Dependencies
import com.diegoferreiracaetano.versions.dependencies.LibsExtension
import com.diegoferreiracaetano.versions.dependencies.TestExtension
import com.github.triplet.gradle.play.PlayPublisherExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.creating
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getValue
import org.gradle.kotlin.dsl.task
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPluginExtension
import org.gradle.testing.jacoco.tasks.JacocoReport
import org.sonarqube.gradle.SonarQubeExtension
import java.io.FileInputStream
import java.util.Properties

class DependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        project.extensions.create("LIBS", Dependencies::class.java)
        project.extensions.create("LIB", LibsExtension::class.java)
        project.extensions.create("TEST", TestExtension::class.java)
        project.extensions.create("ANDROID_TEST", AndroidTestExtension::class.java)

        project.apply {
            it.plugin("jacoco")
            it.plugin("com.android.application")
            it.plugin("kotlin-android")
            it.plugin("kotlin-android-extensions")
            it.plugin("org.sonarqube")

            project.configure<AppExtension> {
                signingConfigs {

                    it.register("customDebug") {
                        it.storeFile = project.file("/debug.keystore")
                        it.storePassword = "android"
                        it.keyAlias = "androiddebugkey"
                        it.keyPassword = "android"
                    }

                    it.register("release") {
                        if (project.file("../signing.properties").canRead()) {
                            val properties = Properties()
                            properties.load(FileInputStream("../signing.properties"))

                            it.storeFile = project.file(properties.getProperty("STORE_FILE"))
                            it.storePassword = properties.getProperty("STORE_PASSWORD")
                            it.keyAlias = properties.getProperty("KEY_ALIAS")
                            it.keyPassword = properties.getProperty("KEY_PASSWORD")
                        } else {
                            it.storeFile = project.file("${project.rootDir}/debug.keystore")
                            it.storePassword = "android"
                            it.keyAlias = "androiddebugkey"
                            it.keyPassword = "android"
                        }
                    }
                }

                compileSdkVersion(AndroidConfig.COMPILE_SDK)
                defaultConfig {
                    it.applicationId = AndroidConfig.APPLICATION_ID
                    it.minSdkVersion(AndroidConfig.MIN_SDK)
                    it.targetSdkVersion(AndroidConfig.TARGET_SDK)
                    it.versionCode = AndroidConfig.VERSION_CODE
                    it.versionName = AndroidConfig.VERSION_NAME
                    it.testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    it.getByName("debug") {
                        it.isTestCoverageEnabled = true
                    }
                    it.getByName("release") {
                        it.signingConfig = signingConfigs.getByName("release")
                        it.isMinifyEnabled = true
                        it.isShrinkResources = true
                    }
                }

                sourceSets {
                    it.getByName("androidTest").java.srcDirs(Source.ANDROID_TEST, Source.SHARED_TEST)
                    it.getByName("androidTest").assets.srcDirs(Source.SHARED_TEST_RESOURCES)
                    it.getByName("main").java.srcDirs(Source.MAIN)
                    it.getByName("test").java.srcDirs(Source.TEST, Source.SHARED_TEST)
                    it.getByName("test").resources.srcDirs(Source.SHARED_TEST_RESOURCES)
                }


                compileOptions {
                    it.sourceCompatibility = AndroidConfig.JAVA_VERSION
                    it.targetCompatibility = AndroidConfig.JAVA_VERSION
                }

                testOptions {
                    it.animationsDisabled = true
                    it.unitTests.apply {
                        isReturnDefaultValues = true
                        isIncludeAndroidResources = true
                    }
                }

                jacoco.version = Versions.JACOCO
            }
        }

        // ######## JaCoCo ##########

        project.configure<JacocoPluginExtension> {
            toolVersion = Versions.JACOCO
        }

        project.task<JacocoReport>("jacocoTestReport") {

            val fileFilter = listOf(
                "**/R.class",
                "**/R$*.class",
                "**/BuildConfig.*",
                "**/Manifest*.*",
                "**/*Test*.*",
                "**/*Entity*.*",
                "android/**/*.*",
                "**/di/**"
            )

            val kotlinTree = project.fileTree(
                mapOf(
                    "dir" to "${project.buildDir}/tmp/kotlin-classes/debug",
                    "excludes" to fileFilter
                )
            )

            val javaTree = project.fileTree(
                mapOf(
                    "dir" to "${project.buildDir}/intermediates/classes/debug",
                    "excludes" to fileFilter
                )
            )


            project.tasks.withType<JacocoReport> {
                group = "Reporting"
                description =
                    "Run tests and generate coverage report for instrumented and jvm testes"
                dependsOn("testDebugUnitTest")

                reports {
                    it.xml.isEnabled = true
                    it.xml.destination =
                        project.file("${project.rootProject.buildDir}/reports/${project.name}/jacocoTestReport.xml")
                    it.html.isEnabled = true
                }

                classDirectories.from(project.files(listOf(javaTree, kotlinTree)))

                val coverageSourceDirs = listOf("src/main/kotlin")

                additionalSourceDirs.from(project.files(coverageSourceDirs))
                sourceDirectories.from(project.files(coverageSourceDirs))

                executionData.from(
                    project.fileTree(
                        mapOf(
                            "dir" to "$project.buildDir",
                            "includes" to listOf(
                                "jacoco/*.exec",
                                "outputs/code_coverage/**/connected/*.ec",
                                "tmp/tests/*.exec",
                                "tmp/tests/*.ec"
                            )
                        )
                    )
                )

                executionData(project.tasks.withType<Test>())

                doLast {
                    println("Jacoco report has been generated to file://${reports.html.destination}")
                }
            }
        }

        // ######## ktlint ##########

        val ktlint by project.configurations.creating

        project.dependencies {
            ktlint(LibsExtension().KTLINT)
        }

        project.task<JavaExec>("ktlint") {
            group = "verification"
            description = "Check Kotlin code style."
            classpath = ktlint
            main = "com.pinterest.ktlint.Main"
            args(
                "--reporter=plain",
                "--reporter=checkstyle,output=${project.buildDir}/ktlint.xml",
                "src/**/*.kt"
            )
        }

        project.tasks.named("check") {
            it.dependsOn(ktlint)
        }

        project.task<JavaExec>("ktlintFormat") {
            group = "formatting"
            description = "Fix Kotlin code style deviations."
            classpath = ktlint
            main = "com.pinterest.ktlint.Main"
            args("--android", "-F", "src/**/*.kt")
        }

        // ######## sonar ##########

        project.configure<SonarQubeExtension> {
            androidVariant = "debug"

            properties {
                it.property("sonar.exclusions", "**/*Module.kt")
                it.property(
                    "sonar.coverage.jacoco.xmlReportPaths",
                    "${project.rootProject.buildDir}/reports/${project.name}/jacocoTestReport.xml"
                )
                it.property("sonar.java.coveragePlugin", "jacoco")
                it.property("sonar.android.lint.report", "build/outputs/lint-results.xml")
            }
        }

        // ######## play ##########

        if (project.file("upload.json").exists()) {
            project.configure<PlayPublisherExtension> {

                serviceAccountCredentials = project.file("upload.json")
                resolutionStrategy = "auto"
                defaultToAppBundles = true
                track = "internal"
            }
        }
    }
}
