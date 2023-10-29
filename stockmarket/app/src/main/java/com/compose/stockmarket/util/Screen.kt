package com.compose.stockmarket.util

sealed class Screen(val route: String) {
    object CompanyListingsScreen: Screen("company_listings_screen")
    object CompanyInfoScreen: Screen("company_info_screen")
}
