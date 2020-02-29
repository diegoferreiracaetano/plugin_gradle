package com.diegoferreiracaetano.versions

object Versions {

    const val KOTLIN = "1.3.61"
    const val SUPPORT_LIBRARY = "1.0.0"
    const val APP_COMPAT = "1.0.2"
    const val LIFECYCLE = "2.2.0-rc02"
    const val PAGING = "1.0.1"
    const val CONSTRAINT_LAYOUT = "1.1.3"
    const val OKHTTP = "3.8.1"
    const val RETROFIT = "2.6.1"
    const val JUNIT = "4.12"
    const val MOCKITO = "2.27.0"
    const val ESPRESSO = "3.1.1"
    const val TEST_RUNNER = "1.1.1"
    const val ROBOLECTRIC = "4.3"
    const val JUNIT_EXT = "1.1.0"
    const val ROOM = "2.2.0-alpha02"
    const val ORCHESTRATOR = "1.0.2"
    const val CORE_TEST = "1.1.0"
    const val CORE_ARCH = "2.0.1"
    const val GSON = "2.8.5"
    const val TIMBER = "4.7.1"
    const val NAVIGATION = "2.1.0"
    const val NAVIGATION_SAFE_ARGS = "1.0.0"
    const val GRADLE = "3.5.2"
    const val CIRCLE_IMAGE = "3.0.0"
    const val KOIN = "2.0.1"
    const val COROUTINES = "1.3.2"
    const val GLIDE = "4.9.0"
    const val MOCKK = "1.9.3"
    const val SHIMMER = "0.4.0"
    const val FRAGMENT_TEST = "1.2.1"
    const val MOCKITO_KOTLLIN = "2.1.0"
    const val JACOCO = "0.8.5"
    const val FLOW_ADAPTER = "0.2.0"
    const val WORKMANAGER = "2.3.0-alpha01"
    const val MAPS = "17.0.0"
    const val KTLINT = "0.34.2"

    fun versionsApp(): Map<String, List<Any>> {
        val map = hashMapOf<String, List<Any>>()
        map[App.NAME] = listOf(App.VERSION_CODE, App.VERSION_NAME)
        map[Style.NAME] = listOf(Style.VERSION_CODE, Style.VERSION_NAME)

        return map
    }
}
