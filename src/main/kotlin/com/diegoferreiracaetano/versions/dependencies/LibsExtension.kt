package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

open class LibsExtension {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN}"
    val appcompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    val coreKtx = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.RECYCLE_VIEW}"
    val material = "com.google.android.material:material:${Versions.MATERIAL_DESING}"
    val junit = "junit:junit:${Versions.JUNIT}"
}
