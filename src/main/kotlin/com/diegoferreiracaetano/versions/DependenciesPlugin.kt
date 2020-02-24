package com.diegoferreiracaetano.versions

import com.android.build.gradle.AppExtension
import com.diegoferreiracaetano.versions.dependencies.AndroidTestExtension
import com.diegoferreiracaetano.versions.dependencies.Dependencies
import com.diegoferreiracaetano.versions.dependencies.LibsExtension
import com.diegoferreiracaetano.versions.dependencies.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.io.File
import java.io.FileInputStream
import java.util.Properties

class DependenciesPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        project.extensions.create("LIBS", Dependencies::class.java)
        project.extensions.create("LIB", LibsExtension::class.java)
        project.extensions.create("TEST", TestExtension::class.java)
        project.extensions.create("ANDROID_TEST", AndroidTestExtension::class.java)

        project.apply {
            //it.plugin("jacoco")
            it.plugin("com.android.application")
            it.plugin("kotlin-android")
            it.plugin("kotlin-android-extensions")

            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/ktlint.gradle")
            //it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/jacoco.gradle")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/sonar.gradle")

            project.configure<AppExtension> {
                signingConfigs {

                    it.register("customDebug") {
                        it.storeFile = File("/debug.keystore")
                        it.storePassword = "android"
                        it.keyAlias = "androiddebugkey"
                        it.keyPassword = "android"
                    }

                    it.register("release") {
                        if (File("../signing.properties").canRead()) {
                            val properties = Properties()
                            properties.load(FileInputStream("../signing.properties"))

                            it.storeFile = File(properties.getProperty("STORE_FILE"))
                            it.storePassword = properties.getProperty("STORE_PASSWORD")
                            it.keyAlias = properties.getProperty("KEY_ALIAS")
                            it.keyPassword = properties.getProperty("KEY_PASSWORD")

                        } else {
                            it.storeFile = File("${project.rootDir}/debug.keystore")
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

                testOptions {
                    it.animationsDisabled = true
                    it.unitTests.apply {
                        isReturnDefaultValues = true
                        isIncludeAndroidResources = true
                    }
                }
            }
        }
    }
}
