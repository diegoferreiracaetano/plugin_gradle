package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

open class AndroidTestExtension {
   companion object {
      const val ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
      const val ESPRESSO_CONTRIB =
         "com.android.support.test.espresso:espresso-contrib:${Versions.ESPRESSO}"
   }
}