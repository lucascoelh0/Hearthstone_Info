package com.example.domain.models

enum class Type {
    MINION,
    SPELL,
    WEAPON,
    HERO,
    LOCATION,
    UNKNOWN;

    companion object {
        fun get(value: String) = Type.values().firstOrNull {
            it.name.contains(value, ignoreCase = true)
        } ?: UNKNOWN
    }
}
