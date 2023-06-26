package com.judahben149.countrycookbook.domain.model

data class Country(
    val id: String = "",
    val name: String = "",
    val capital: String = "",
    val flag: String = "",
    val phoneCode: String = "",
    val nativeName: String = "",
    val currencies: List<String> = emptyList(),
    val languageList: List<Language> = emptyList(),
    val states: List<State> = emptyList(),
    val subdivisions: List<Subdivision> = emptyList()
)

data class Language(
    val name: String = "",
    val nativeName: String = "",
)

data class State(
    val id: String = "",
    val name: String = "",
)

data class Subdivision(
    val id: String = "",
    val name: String = "",
    val flag: String = "",
)
