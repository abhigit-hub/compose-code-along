package com.compose.stockmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.compose.stockmarket.presentation.companyinfo.CompanyInfoScreen
import com.compose.stockmarket.presentation.companylistings.CompanyListingsScreen
import com.compose.stockmarket.ui.theme.StockMarketTheme
import com.compose.stockmarket.util.Screen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockMarketTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.CompanyListingsScreen.route
                    ) {
                        composable(route = Screen.CompanyListingsScreen.route) {
                            CompanyListingsScreen(navController)
                        }

                        composable(
                            route = Screen.CompanyInfoScreen.route + "?symbol={symbol}",
                            arguments = listOf(
                                navArgument(name = "symbol") {
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )
                        ) {
                            val symbol = it.arguments?.getString("symbol") ?: ""
                            CompanyInfoScreen(symbol = symbol)
                        }
                    }
                }
            }
        }
    }
}