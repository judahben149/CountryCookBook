package com.judahben149.countrycookbook.utils


fun String.toContinentName(): String {
    return when(this) {
        "AF" -> "Africa"
        "AN" -> "Antarctica"
        "AS" -> "Asia"
        "EU" -> "Europe"
        "NA" -> "North America"
        "OC" -> "Oceania"
        "SA" -> "South America"
        else -> "Unknown"
    }
}