package com.diegoferreiracaetano.versions.dependencies

import com.diegoferreiracaetano.versions.Versions

open class LibsExtension {
     val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
     val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.OKHTTP}"
     val OKHTTP_LOGGER = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP}"
     val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
     val RETROFIT_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
     val GSON = "com.google.code.gson:gson:${Versions.GSON}"
     val MATERIAL_DESING = "com.google.android.material:material:${Versions.SUPPORT_LIBRARY}"
     val PAGING = "android.arch.paging:runtime:${Versions.PAGING}"
     val TIMBER = "com.jakewharton.timber:timber:${Versions.TIMBER}"
     val CIRCLE_IMAGE = "de.hdodenhof:circleimageview:${Versions.CIRCLE_IMAGE}"
     val GLIDE = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
     val SHIMMER = "com.facebook.shimmer:shimmer:${Versions.SHIMMER}"
     val FLOW_ADAPTER = "com.github.MohammadSianaki:Retrofit2-Flow-Call-Adapter:${Versions.FLOW_ADAPTER}"
     val MAPS = "com.google.android.gms:play-services-maps:${Versions.MAPS}"

    object Android {
         val EXIF_INTERFACE = "androidx.exifinterface:exifinterface:${Versions.SUPPORT_LIBRARY}"
         val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
         val FRAGMENT = "androidx.fragment:fragment:${Versions.SUPPORT_LIBRARY}"
         val CARD_VIEW = "androidx.cardview:cardview:${Versions.SUPPORT_LIBRARY}"
         val RECYCLER_VIEW = "androidx.recyclerview:recyclerview:${Versions.SUPPORT_LIBRARY}"
         val RAINT_LAYOUT = "androidx.raintlayout:raintlayout:${Versions.RAINT_LAYOUT}"
         val DESIGN = "com.android.support:design:${Versions.SUPPORT_LIBRARY}"
         val CORE_COMMON = "androidx.arch.core:core-common:${Versions.CORE_ARCH}"
         val CORE_RUNTIME = "androidx.arch.core:core-runtime:${Versions.CORE_ARCH}"
    }

    object Workmanager {
         val RUNTIME = "androidx.work:work-runtime-ktx:${Versions.WORKMANAGER}"
         val TEST = "androidx.work:work-testing:${Versions.WORKMANAGER}"
    }

    object Lifecycle {
         val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
         val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
         val RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
         val COMPILER = "androidx.lifecycle:lifecycle-compiler-ktx:${Versions.LIFECYCLE}"
    }

    object COROUTINES {
         val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
         val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    }

    object Navigation {
         val UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
         val FRAGMENT = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    }

    object Room {
         val COMPILER = "androidx.room:room-compiler:${Versions.ROOM}"
         val RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
         val ROOM = "androidx.room:room-ktx:${Versions.ROOM}"
    }
}
