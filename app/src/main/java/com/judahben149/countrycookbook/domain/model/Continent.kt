package com.judahben149.countrycookbook.domain.model

import com.judahben149.type.Continent

data class Continent(
    val id: String = "",
    val name: String = "",
    val countryList: List<Country> = emptyList()
)
