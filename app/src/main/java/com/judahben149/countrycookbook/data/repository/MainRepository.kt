package com.judahben149.countrycookbook.data.repository

import com.judahben149.countrycookbook.data.network.ApolloCountryClient
import javax.inject.Inject

class MainRepository @Inject constructor(private val apolloCountryClient: ApolloCountryClient) {

    suspend fun getContinentList() = apolloCountryClient.getContinentList() ?: emptyList()

    suspend fun getContinentDetails(continentCode: String) = apolloCountryClient.getContinentDetails(continentCode)

    suspend fun getCountryDetails(countryCode: String) = apolloCountryClient.getCountryDetails(countryCode)
}