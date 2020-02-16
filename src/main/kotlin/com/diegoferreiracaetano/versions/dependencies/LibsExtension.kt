package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

object LibsExtension {
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
    const val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val GSON = "com.google.code.gson:gson:${Versions.GSON}"
    const val MATERIAL_DESING = "com.google.android.material:material:${Versions.SUPPORT_LIBRARY}"
    const val PAGING = "android.arch.paging:runtime:${Versions.PAGING}"
    const val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
    const val CIRCLE_IMAGE = "de.hdodenhof:circleimageview:${Versions.CIRCLE_IMAGE}"
    const val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val SHIMMER = "com.facebook.shimmer:shimmer:${Versions.SHIMMER}"
    const val FLOW_ADAPTER = "com.github.MohammadSianaki:Retrofit2-Flow-Call-Adapter:${Versions.FLOW_ADAPTER}"
    const val MAPS = "com.google.android.gms:play-services-maps:${Versions.MAPS}"

    object Android {
        const val EXIF_INTERFACE = "androidx.exifinterface:exifinterface:${Versions.SUPPORT_LIBRARY}"
        const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
        const val FRAGMENT = "androidx.fragment:fragment:${Versions.SUPPORT_LIBRARY}"
        const val CARD_VIEW = "androidx.cardview:cardview:${Versions.SUPPORT_LIBRARY}"
        const val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.SUPPORT_LIBRARY}"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
        const val DESIGN = "com.android.support:design:${Versions.SUPPORT_LIBRARY}"
        const val CORE_COMMON = "androidx.arch.core:core-common:${Versions.CORE_ARCH}"
        const val CORE_RUNTIME = "androidx.arch.core:core-runtime:${Versions.CORE_ARCH}"
    }

    object Workmanager {
        const val RUNTIME = "androidx.work:work-runtime-ktx:${Versions.WORKMANAGER}"
        const val TEST = "androidx.work:work-testing:${Versions.WORKMANAGER}"
    }

    object Lifecycle {
        const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
        const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
        const val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
        const val COMPILER = "androidx.lifecycle:lifecycle-compiler-ktx:${Versions.LIFECYCLE}"
    }

    object COROUTINES {
        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    }

    object Navigation {
        const val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
        const val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    }

    object Room {
        const val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
        const val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
        const val ROOM = "androidx.room:room-ktx:${Versions.ROOM}"
    }
}
