package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.detail.UserDetailsScreen
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.favorite.FavoriteScreen
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home.HomeScreen
import sistemas.jd.gomes.androidcleanarchicturemarvel.util.Constants

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.UserDetails.route,
            arguments = listOf(navArgument(Constants.USER_DETAILS_ARGUMENT_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString(Constants.USER_DETAILS_ARGUMENT_KEY)
                ?.let { UserDetailsScreen(it, navController) }
        }
        composable(route = Screen.Favorite.route) {
             FavoriteScreen(navController = navController)
        }
    }
}

