package jp.hotdrop.composeDesignApp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.hotdrop.composeDesignApp.ui.start.SplashPage

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splashPage") {
        composable("splashPage") { SplashPage(navController = navController) }
    }
}