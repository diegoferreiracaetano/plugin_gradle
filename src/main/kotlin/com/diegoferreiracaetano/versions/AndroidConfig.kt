package com.diegoferreiracaetano.versions

import org.gradle.api.JavaVersion.VERSION_1_8

object AndroidConfig {

    const val COMPILE_SDK = 28
    const val MIN_SDK = 21
    const val TARGET_SDK = COMPILE_SDK
    val JAVA_VERSION = VERSION_1_8
    const val VERSION_CODE = 1
    const val VERSION_NAME = "0.0.1"
}

object Source {
    const val MAIN = "src/main/kotlin"
    const val TEST = "src/test/kotlin"
    const val ANDROID_TEST = "src/androidTest/kotlin"
    const val SHARED_TEST = "src/sharedTest/kotlin"
    const val SHARED_TEST_RESOURCES = "src/sharedTest/resources"
}