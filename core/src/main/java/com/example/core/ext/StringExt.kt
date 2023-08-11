package com.example.core.ext

fun String.formatCardText(): String {
    return replace("<[^>]*>".toRegex(), "").replace("$", "")
}
