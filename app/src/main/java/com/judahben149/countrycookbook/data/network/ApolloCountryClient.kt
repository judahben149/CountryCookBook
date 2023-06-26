package com.judahben149.countrycookbook.data.network

import com.apollographql.apollo3.ApolloClient
import com.judahben149.GetAllContinentsQuery
import com.judahben149.countrycookbook.data.network.dto.ContinentDTO
import com.judahben149.countrycookbook.domain.mapper.toContinent
import com.judahben149.countrycookbook.domain.model.Continent
import com.judahben149.countrycookbook.domain.network.CountryClient
import javax.inject.Inject

class ApolloCountryClient @Inject constructor(private val apolloClient: ApolloClient): CountryClient {

    override suspend fun getContinentList(): List<Continent>? {
        return apolloClient.query(GetAllContinentsQuery()).execute().data?.continents?.map {
            it.toContinent()
        }
    }
}