package com.diegoferreiracaetano.versions.dependencies

open class DefaultExtension {
   val LIBS = listOf(
      LibsExtension.Android.APP_COMPAT,
      LibsExtension.Android.CONSTRAINT_LAYOUT,
      LibsExtension.Android.RECYCLER_VIEW,
      LibsExtension.Android.FRAGMENT,
      LibsExtension.Android.CORE_COMMON,
      LibsExtension.Android.CORE_RUNTIME,
      LibsExtension.Android.DESIGN
   )

   val TEST = listOf(
      TestExtension.KOTLIN,
      TestExtension.CORE,
      TestExtension.ESPRESSO,
      TestExtension.COROUTINES,
      TestExtension.FRAGMENT_TEST,
      TestExtension.JUNIT,
      TestExtension.JUNIT_EXT,
      TestExtension.KOIN,
      TestExtension.MOCKITO,
      TestExtension.MOCKK
   )
}