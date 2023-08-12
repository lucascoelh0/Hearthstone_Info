package com.example.domain.models

enum class Faction {
    ALLIANCE,
    HORDE,
    EMPIRE,
    EXPLORER,
    LEGION,
    PIRATE,
    SCOURGE,
    UNKNOWN;

    companion object {
        fun get(value: String) = Faction.values().firstOrNull {
            it.name.contains(value, ignoreCase = true)
        } ?: UNKNOWN
    }
}
