package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.detail

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppContentColor
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppThemColor

@Composable
fun UserDetailsScreen(
    userId: String,
    navController: NavController,
    viewModel: UserDetailsViewModel = hiltViewModel()
) {

    viewModel.getUserDetails(userId = userId.toInt())
    val userDetails by viewModel.selectedUser.collectAsState()
    Scaffold(
        topBar = {
            UserDetailsTopBar(navController)
        },
        contentColor = MaterialTheme.colors.AppContentColor,
        backgroundColor = MaterialTheme.colors.AppThemColor,
        content = {
            userDetails?.let {
                UserDetailsContent(it)
            }
        }
    )
}