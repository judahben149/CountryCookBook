package com.judahben149.countrycookbook.domain.mapper

import com.judahben149.GetAllContinentsQuery
import com.judahben149.countrycookbook.domain.model.Continent

fun GetAllContinentsQuery.Continent.toContinent(): Continent {
    return Continent(id = this.code, name = this.name)
}