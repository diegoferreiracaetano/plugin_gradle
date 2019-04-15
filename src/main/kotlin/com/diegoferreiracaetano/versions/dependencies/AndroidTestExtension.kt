package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

open class AndroidTestExtension {
    val runner = "androidx.test:runner:${Versions.RUNNER}"
    val espresso =  "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
}