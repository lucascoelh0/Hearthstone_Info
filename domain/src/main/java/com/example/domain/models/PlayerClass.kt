package com.example.domain.models

enum class PlayerClass(val value: String) {
    DEATH_KNIGHT("Death Knight"),
    DEMON_HUNTER("Demon Hunter"),
    DRUID("Druid"),
    HUNTER("Hunter"),
    MAGE("Mage"),
    PALADIN("Paladin"),
    PRIEST("Priest"),
    ROGUE("Rogue"),
    SHAMAN("Shaman"),
    WARLOCK("Warlock"),
    WARRIOR("Warrior"),
    NEUTRAL("Neutral"),
    UNKNOWN("Unknown");

    companion object {
        fun get(value: String) = PlayerClass.values().firstOrNull {
            it.value.contains(value, ignoreCase = true)
        } ?: UNKNOWN
    }
}
