package com.mbahgojol.myapplication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform