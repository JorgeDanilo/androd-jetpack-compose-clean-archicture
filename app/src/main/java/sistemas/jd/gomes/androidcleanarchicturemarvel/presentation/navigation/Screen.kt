package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object UserDetails : Screen("user_details_screen/{userId}") {
        fun passUserId(userId: String) = "user_details_screen/$userId"
    }
}
