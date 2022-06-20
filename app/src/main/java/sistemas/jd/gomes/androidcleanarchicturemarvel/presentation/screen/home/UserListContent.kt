package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.size.Scale
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.navigation.Screen
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.ItemBackgroundColor
import sistemas.jd.gomes.domain.model.User

@Composable
fun UserListContent(
    allUsers: LazyPagingItems<User>,
    navController: NavHostController
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp)
    ) {
        items(
            items = allUsers,
            key = { user ->
                user.pk
            }
        ) { user ->
            if (user != null) {
                UserListItem(user = user, navController = navController)
            }
        }
    }
}

@Composable
fun UserListItem(user: User, navController: NavHostController) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .height(120.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.ItemBackgroundColor
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max)
                .fillMaxWidth()
                .clickable {
                    navController.navigate(route = Screen.UserDetails.passUserId(user.id.toString()))
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            user.avatar?.let {
                Surface(
                    modifier = Modifier.size(130.dp),
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colors.surface.copy(alpha = 0.2f)
                ) {
                    Image(
                        modifier = Modifier
                            .padding(
                                end = 4.dp
                            )
                            .width(100.dp)
                            .clip(shape = RoundedCornerShape(12.dp)),
                        painter = rememberImagePainter(
                            data = user.avatar, builder = {
                                crossfade(true)
                                scale(Scale.FILL)
                            }
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }

            Column(
                Modifier
                    .height(IntrinsicSize.Max)
                    .padding(
                        end = 2.dp
                    )
            ) {
                user.firstName?.let { Text(text = it, style = MaterialTheme.typography.body1) }
                Spacer(modifier = Modifier.height(4.dp))
                user.lastName?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                user.email?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}