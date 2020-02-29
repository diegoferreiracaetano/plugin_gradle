package com.diegoferreiracaetano.versions

object ModuleConfig {

    val app = Modules(
        "app",
        "com.diegoferreiracaetano.driver.app",
        1,
        "0.0.1"
    )

    val style = Modules(
        "style",
        "com.diegoferreiracaetano.driver.app",
        1,
        "0.0.1"
    )

    val list = listOf(app, style)
}