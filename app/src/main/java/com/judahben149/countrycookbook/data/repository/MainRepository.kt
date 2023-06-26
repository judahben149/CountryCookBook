package com.judahben149.countrycookbook.data.repository

import com.judahben149.countrycookbook.data.network.ApolloCountryClient
import javax.inject.Inject

class MainRepository @Inject constructor(private val apolloCountryClient: ApolloCountryClient) {

    suspend fun getContinentList() = apolloCountryClient.getContinentList()?.let { it } ?: emptyList()
}