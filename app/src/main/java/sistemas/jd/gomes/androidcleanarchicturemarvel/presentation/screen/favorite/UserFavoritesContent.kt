package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.favorite

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.navigation.Screen
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home.UserListItem
import sistemas.jd.gomes.domain.model.User

@Composable
fun UserFavoritesContent(
    favoritesUsers: List<User>,
    navController: NavHostController,
    onClick: (User) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(favoritesUsers) { user ->
            UserListItem(user = user, onItemClick = {
                navController.navigate(route = Screen.UserDetails.passUserId(it.id.toString()))
            }, onClick = {
                Log.d("UserFavoritesContent", "Clicked on user: ${it.firstName}")
            })
        }
    }
}