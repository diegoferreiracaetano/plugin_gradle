package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

open class TestExtension {

    companion object {
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-test:${Versions.KOTLIN}"
        const val JUNIT = "junit:junit:${Versions.JUNIT}"
        const val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
        const val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
        const val RUNNER = "androidx.test:runner:${Versions.TEST_RUNNER}"
        const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
        const val ESPRESSO_CONTRIB =
            "com.android.support.test.espresso:espresso-contrib:${Versions.ESPRESSO}"
        const val CORE = "android.arch.core:core-testing:${Versions.CORE_TEST}"
        const val COROUTINES =
            "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
        const val ROBOELETRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC}"
        const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${Versions.FRAGMENT_TEST}"
        const val KOIN = "org.koin:koin-test:${Versions.KOIN}"
        const val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"
        const val MOCKITO = "org.mockito:mockito-android:${Versions.MOCKITO}"
        const val MOCKITO_KOTLIN =
            "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLLIN}"
        const val ORCHESTRATOR = "com.android.support.test:orchestrator:${Versions.ORCHESTRATOR}"
    }
}