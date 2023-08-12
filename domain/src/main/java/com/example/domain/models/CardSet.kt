package com.example.domain.models

enum class CardSet(val value: String) {
    BASIC("Basic"),
    CLASSIC("Classic"),
    HALL_OF_FAME("Hall of Fame"),
    NAXXRAMAS("Naxxramas"),
    GOBLINS_VS_GNOMES("Goblins vs Gnomes"),
    BLACKROCK_MOUNTAIN("Blackrock Mountain"),
    THE_GRAND_TOURNAMENT("The Grand Tournament"),
    THE_LEAGUE_OF_EXPLORERS("The League of Explorers"),
    WHISPERS_OF_THE_OLD_GODS("Whispers of the Old Gods"),
    ONE_NIGHT_IN_KARAZHAN("One Night in Karazhan"),
    MEAN_STREETS_OF_GADGETZAN("Mean Streets of Gadgetzan"),
    JOURNEY_TO_UNGORO("Journey to Un'Goro"),
    KNIGHTS_OF_THE_FROZEN_THRONE("Knights of the Frozen Throne"),
    KOBOLDS_AND_CATACOMBS("Kobolds & Catacombs"),
    THE_WITCHWOOD("The Witchwood"),
    THE_BOOMSDAY_PROJECT("The Boomsday Project"),
    RASTAKHANS_RUMBLE("Rastakhan's Rumble"),
    RISE_OF_SHADOWS("Rise of Shadows"),
    SAVIORS_OF_ULDUM("Saviors of Uldum"),
    DESCENT_OF_DRAGONS("Descent of Dragons"),
    GALAKROND_S_AWAKENING("Galakrond's Awakening"),
    ASHES_OF_OUTLANDS("Ashes of Outland"),
    SCHOLOMANCE_ACADEMY("Scholomance Academy"),
    DEMON_HUNTER_INITIATE("Demon Hunter Initiate"),
    FORGED_IN_THE_BARRENS("Forged in the Barrens"),
    CORE("Core"),
    UNITED_IN_STORMWIND("United in Stormwind"),
    FRACTURED_IN_ALTERAC_VALLEY("Fractured in Alterac Valley"),
    VOYAGE_TO_THE_SUNKEN_CITY("Voyage to the Sunken City"),
    MURDER_AT_CASTLE_NATHRIA("Murder at Castle Nathria"),
    MARCH_OF_THE_LICH_KING("March of the Lich King"),
    PATH_OF_ARTHAS("Path of Arthas"),
    FESTIVAL_OF_LEGENDS("Festival of Legends"),
    TITANS("TITANS"),
    UNKNOWN("Unknown"),
    OTHER("Other");

    companion object {
        fun get(value: String) = CardSet.values().firstOrNull {
            it.value.contains(value, ignoreCase = true)
        } ?: OTHER
    }
}
