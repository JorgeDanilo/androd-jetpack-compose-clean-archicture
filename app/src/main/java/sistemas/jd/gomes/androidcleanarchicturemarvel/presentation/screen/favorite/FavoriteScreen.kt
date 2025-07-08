package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.favorite

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppContentColor
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppThemColor

@Composable
fun FavoriteScreen(
    navController: NavHostController,
    viewModel: FavoriteViewModel = hiltViewModel()
) {

    val systemUiController = rememberSystemUiController()
    val systemBarColor = MaterialTheme.colors.AppThemColor
    val favoritesUsers by viewModel.favoritesUsers.collectAsState()
    val coroutineScope = rememberCoroutineScope()


    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }

    Scaffold(
        backgroundColor = MaterialTheme.colors.AppThemColor,
        contentColor = MaterialTheme.colors.AppContentColor,
        topBar = {
            FavoriteTopBar(navController)
        },
        content = {
            UserFavoritesContent(
                favoritesUsers = favoritesUsers,
                navController = navController,
                onClick = { user ->
                    coroutineScope.launch {
                        viewModel.saveFavorite(user)
                    }
                }
            )
        }
    )
}

