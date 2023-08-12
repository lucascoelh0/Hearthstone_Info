package com.example.core.ext

import java.util.Locale

fun String.formatCardText(): String {
    return replace("<[^>]*>".toRegex(), "").replace("$", "")
}

fun String.capitalizeFirstLetter(): String {
    if (isEmpty()) {
        return this
    }
    return this[0].uppercaseChar() + this.substring(1).lowercase(Locale.ROOT)
}
