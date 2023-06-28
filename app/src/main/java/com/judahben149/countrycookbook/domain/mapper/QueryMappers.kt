package com.judahben149.countrycookbook.domain.mapper

import com.judahben149.GetAllContinentsQuery
import com.judahben149.GetAllCountriesQuery
import com.judahben149.GetCountryDetailsQuery
import com.judahben149.countrycookbook.domain.model.*

fun GetAllContinentsQuery.Continent.toContinent(): Continent {
    return Continent(id = this.code, name = this.name)
}

fun GetAllCountriesQuery.Continent.toContinent(): Continent {
    return Continent(
        id = this.code,
        name = this.name,
        countryList = this.countries.map { it.toCountry() }
    )
}

fun GetAllCountriesQuery.Country.toCountry(): Country {
    return Country(
        id = this.code,
        name = this.name,
        capital = this.capital ?: "N/A",
        flag = this.emoji
    )
}

fun GetCountryDetailsQuery.Country.toCountry(): Country {
    return Country(
        id = this.code,
        name = this.name,
        capital = this.capital ?: "N/A",
        flag = this.emoji,
        phoneCode = this.phone,
        nativeName = this.native,
        currencies = this.currencies,
        languageList = this.languages.map { it.toLanguage() },
        states = this.states.map { it.toState() },
        subdivisions = this.subdivisions.map { it.toSubdivision() }
    )
}

fun GetCountryDetailsQuery.Language.toLanguage(): Language {
    return Language(this.name, this.native)
}

fun GetCountryDetailsQuery.State.toState(): State {
    return State(
        id = this.code ?: "N/A",
        name = this.name
    )
}

fun GetCountryDetailsQuery.Subdivision.toSubdivision(): Subdivision {
    return Subdivision(
        id = this.code,
        name = this.name,
        flag = this.emoji ?: ""
    )
}
