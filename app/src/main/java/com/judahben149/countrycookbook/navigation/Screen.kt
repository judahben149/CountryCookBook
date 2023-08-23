package com.judahben149.countrycookbook.navigation

sealed class Screen(val route: String) {
    object ContinentListScreen: Screen("continent_list_screen")
    object CountryListScreen: Screen("country_list_screen/{continentId}")
    object CountryDetailScreen: Screen("country_detail_screen/{countryId}")
}
