package jp.hotdrop.composeDesignApp.ui

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NavigationViewModel @Inject constructor() : ViewModel() {
    private lateinit var navController: NavController

    fun init(controller: NavController) {
        navController = controller
    }

    fun toStartPage() {
        navController.navigate(START_PAGE)
    }

    companion object {
        const val SPLASH_PAGE: String = "SplashPage"
        const val START_PAGE: String = "StartPage"
    }
}
