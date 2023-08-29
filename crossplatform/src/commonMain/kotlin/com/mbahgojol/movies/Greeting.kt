@file:Suppress("unused")

package com.mbahgojol.movies

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
