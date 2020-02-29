package com.diegoferreiracaetano.versions

object ModuleConfig {

    val app = Modules(
        "app",
        1,
        "0.0.1"
    )

    val style = Modules(
        "style",
        1,
        "0.0.1"
    )

    val list = listOf(app, style)
}