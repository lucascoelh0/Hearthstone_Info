package com.example.domain.models

enum class Rarity {
    FREE,
    COMMON,
    RARE,
    EPIC,
    LEGENDARY,
    UNKNOWN;

    companion object {
        fun get(value: String) = Rarity.values().firstOrNull {
            it.name.contains(value, ignoreCase = true)
        } ?: UNKNOWN
    }
}
