package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

open class TestExtension {
      val KOTLIN = "org.jetbrains.kotlin:kotlin-test:${Versions.KOTLIN}"
      val JUNIT = "junit:junit:${Versions.JUNIT}"
      val JUNIT_EXT = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
      val MOCKK = "io.mockk:mockk:${Versions.MOCKK}"
      val RUNNER = "androidx.test:runner:${Versions.TEST_RUNNER}"
      val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
      val ESPRESSO_CONTRIB = "com.android.support.test.espresso:espresso-contrib:${Versions.ESPRESSO}"
      val CORE = "android.arch.core:core-testing:${Versions.CORE_TEST}"
      val COROUTINES = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
      val ROBOELETRIC = "org.robolectric:robolectric:${Versions.ROBOLECTRIC}"
      val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${Versions.FRAGMENT_TEST}"
      val KOIN = "org.koin:koin-test:${Versions.KOIN}"
      val MOCKK_ANDROID = "io.mockk:mockk-android:${Versions.MOCKK}"
      val MOCKITO = "org.mockito:mockito-android:${Versions.MOCKITO}"
      val MOCKITO_KOTLIN = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.MOCKITO_KOTLLIN}"
      val ORCHESTRATOR = "com.android.support.test:orchestrator:${Versions.ORCHESTRATOR}"
}