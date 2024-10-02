package de.syntax_institut.jpc

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import de.syntax_institut.jpc.ScreenConstants.DETAILS_SCREEN
import de.syntax_institut.jpc.ScreenConstants.HOME_SCREEN
import de.syntax_institut.jpc.ScreenConstants.ONBOARDING_SCREEN

@Composable
fun NavGraph(
    navController: NavHostController
) {

    NavHost(navController = navController, startDestination = Screens.OnboardingScreen.route) {

        composable(
            route = Screens.OnboardingScreen.route
        ) {
            OnboardingScreen(navController)
        }

        composable(
            route = Screens.HomeScreen.route
        ) {
            HomeScreen(navController)
        }

        composable(
            route = Screens.DetailsScreen.route

        ) {

            val result = navController.previousBackStackEntry?.savedStateHandle?.get<Coffee>("coffeeInfo")

            if (result != null) {
                DetailsScreen(navController, result)
            }
        }
    }
}

object ScreenConstants {

    const val ONBOARDING_SCREEN = "onboarding_screen"
    const val HOME_SCREEN = "home_screen"
    const val DETAILS_SCREEN = "details_screen"
}
//jede data object is singleton object representing strings
//sealed
open class Screens(val route: String) {

    data object OnboardingScreen : Screens(ONBOARDING_SCREEN)
    data object HomeScreen : Screens(HOME_SCREEN)
    data object DetailsScreen : Screens(DETAILS_SCREEN)


}