package com.judahben149.countrycookbook.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.judahben149.countrycookbook.presentation.countryList.CountryListScreen
import com.judahben149.countrycookbook.presentation.screens.ContinentListScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ContinentListScreen.route) {

        composable(route = Screen.ContinentListScreen.route) {
            ContinentListScreen(navController = navController)
        }

        composable(route = Screen.CountryListScreen.route) {
            val continentId = it.arguments?.getString("continentId")

            continentId?.let { id ->
                CountryListScreen(navController = navController, continentId = id)
            }
        }


    }
}