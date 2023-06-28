package com.judahben149.countrycookbook.domain.network

import com.judahben149.countrycookbook.domain.model.Continent
import com.judahben149.countrycookbook.domain.model.Country

interface CountryClient {

    suspend fun getContinentList(): List<Continent>?

    suspend fun getContinentDetails(continentCode: String): Continent?

    suspend fun getCountryDetails(countryCode: String): Country?
}