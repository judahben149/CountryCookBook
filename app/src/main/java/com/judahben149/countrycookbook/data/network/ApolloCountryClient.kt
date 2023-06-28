package com.judahben149.countrycookbook.data.network

import com.apollographql.apollo3.ApolloClient
import com.judahben149.GetAllContinentsQuery
import com.judahben149.GetAllCountriesQuery
import com.judahben149.GetCountryDetailsQuery
import com.judahben149.countrycookbook.domain.mapper.toContinent
import com.judahben149.countrycookbook.domain.mapper.toCountry
import com.judahben149.countrycookbook.domain.model.Continent
import com.judahben149.countrycookbook.domain.model.Country
import com.judahben149.countrycookbook.domain.network.CountryClient
import javax.inject.Inject

class ApolloCountryClient @Inject constructor(private val apolloClient: ApolloClient): CountryClient {

    override suspend fun getContinentList(): List<Continent>? {
        return apolloClient.query(GetAllContinentsQuery()).execute().data?.continents?.map {
            it.toContinent()
        }
    }

    override suspend fun getContinentDetails(continentCode: String): Continent? {
        return apolloClient.query(GetAllCountriesQuery(continentCode)).execute().data?.continent?.toContinent()
    }

    override suspend fun getCountryDetails(countryCode: String): Country? {
        return apolloClient.query(GetCountryDetailsQuery(countryCode)).execute().data?.country?.toCountry()
    }
}