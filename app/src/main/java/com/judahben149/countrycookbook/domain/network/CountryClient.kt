package com.judahben149.countrycookbook.domain.network

import com.judahben149.countrycookbook.data.network.dto.ContinentDTO
import com.judahben149.countrycookbook.domain.model.Continent

interface CountryClient {

    suspend fun getContinentList(): List<Continent>?
}