package com.diegoferreiracaetano.versions

import com.diegoferreiracaetano.versions.dependencies.AndroidTestExtension
import com.diegoferreiracaetano.versions.dependencies.Dependencies
import com.diegoferreiracaetano.versions.dependencies.LibsExtension
import com.diegoferreiracaetano.versions.dependencies.TestExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class DependenciesPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("LIBS", Dependencies::class.java)
        project.extensions.create("LIB", LibsExtension::class.java)
        project.extensions.create("TEST", TestExtension::class.java)
        project.extensions.create("ANDROID_TEST", AndroidTestExtension::class.java)
        project.apply {
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/ktlint.gradle")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/jacoco.gradle")
            it.from("https://raw.githubusercontent.com/diegoferreiracaetano/plugin_gradle/master/tools/sonar.gradle")
            it.plugin("jacoco")

            if (project.hasProperty("android")) {
                it.plugin("kotlin-android")
                it.plugin("kotlin-android-extensions")

                if (project.name == "app") {

                    it.plugin("com.android.application")
                    it.plugin("com.github.triplet.play:2.6.2")

                    android {

                        signingConfigs {

                            register("customDebug") {
                                storeFile = file("$rootDir/debug.keystore")
                                storePassword = "android"
                                keyAlias = "androiddebugkey"
                                keyPassword = "android"
                            }

                            register("release") {
                                if (file("../signing.properties").canRead()) {
                                    val properties = Properties()
                                    properties.load(FileInputStream("../signing.properties"))

                                    storeFile = file(properties.getProperty("STORE_FILE"))
                                    storePassword = properties.getProperty("STORE_PASSWORD")
                                    keyAlias = properties.getProperty("KEY_ALIAS")
                                    keyPassword = properties.getProperty("KEY_PASSWORD")

                                } else {
                                    storeFile = file("$rootDir/debug.keystore")
                                    storePassword = "android"
                                    keyAlias = "androiddebugkey"
                                    keyPassword = "android"
                                }
                            }
                        }

                        compileSdkVersion(AndroidConfig.COMPILE_SDK)
                        defaultConfig {
                            applicationId = AndroidConfig.APPLICATION_ID
                            minSdkVersion(AndroidConfig.MIN_SDK)
                            targetSdkVersion(AndroidConfig.TARGET_SDK)
                            versionCode = AndroidConfig.VERSION_CODE
                            versionName = AndroidConfig.VERSION_NAME
                            testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                        }

                        buildTypes {
                            getByName("debug") {
                                isTestCoverageEnabled = true
                            }
                            getByName("release") {
                                signingConfig = signingConfigs.getByName("release")
                                isMinifyEnabled = true
                                isShrinkResources = true
                                proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.txt")
                            }
                        }

                        sourceSets {
                            getByName("androidTest").java.srcDirs(Source.ANDROID_TEST, Source.SHARED_TEST)
                            getByName("androidTest").assets.srcDirs(Source.SHARED_TEST_RESOURCES)
                            getByName("main").java.srcDirs(Source.MAIN)
                            getByName("test").java.srcDirs(Source.TEST, Source.SHARED_TEST)
                            getByName("test").resources.srcDirs(Source.SHARED_TEST_RESOURCES)
                        }

                        testOptions {
                            unitTests.isIncludeAndroidResources = true
                            unitTests.isReturnDefaultValues = true

                            animationsDisabled = true
                        }
                    }
                }
            }
        }
    }
}
