package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

open class Dependencies {

    private val test = TestExtension()
    private val libs = LibsExtension()
    private val android = LibsExtension().Android()

    val DEFAULT_LIBS = listOf(
        android.APP_COMPAT,
        android.CONSTRAINT_LAYOUT,
        android.RECYCLER_VIEW,
        android.FRAGMENT,
        android.CORE_COMMON,
        android.CORE_RUNTIME,
        android.DESIGN,
        libs.KOTLIN,
        libs.Koin().SCOPE
    )

    val DEFAULT_TEST = listOf(
        test.KOTLIN,
        test.CORE,
        test.ESPRESSO,
        test.COROUTINES,
        test.JUNIT,
        test.JUNIT_EXT,
        test.KOIN,
        test.MOCKITO,
        test.MOCKK,
        test.RUNNER,
        test.ESPRESSO_CONTRIB,
        test.ROBOELETRIC,
        test.MOCKK_ANDROID,
        test.MOCKITO_KOTLIN
    )
}
