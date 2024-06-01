package jp.hotdrop.composeDesignApp.ui

import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import jp.hotdrop.composeDesignApp.ui.start.SplashPage
import jp.hotdrop.composeDesignApp.ui.start.StartPage

@Composable
fun AppNavigation(
    navigationViewModel: NavigationViewModel = hiltViewModel(LocalContext.current as ComponentActivity)
) {
    val navController = rememberNavController()
    navigationViewModel.init(navController)
    NavHost(navController = navController, startDestination = NavigationViewModel.SPLASH_PAGE) {
        composable(NavigationViewModel.SPLASH_PAGE) { SplashPage() }
        composable(NavigationViewModel.START_PAGE) { StartPage() }
    }
}