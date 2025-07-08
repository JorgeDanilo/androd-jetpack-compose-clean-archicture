package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberImagePainter
import coil.size.Scale
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.components.SearchField
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.navigation.Screen
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.ItemBackgroundColor
import sistemas.jd.gomes.domain.model.User

@Composable
fun UserListContent(
    allUsers: LazyPagingItems<User>,
    navController: NavHostController,
    searchQuery: String,
    onQueryChanged: (String) -> Unit,
    onClick: (User) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        SearchField(
            searchQuery = searchQuery,
            onQueryChanged = onQueryChanged,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

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
                    UserListItem(user = user, onItemClick = {
                        navController.navigate(route = Screen.UserDetails.passUserId(it.id.toString()))
                    }, onClick = {
                        onClick(user)
                    })
                }
            }
        }
    }

}

@Composable
fun UserListItem(
    user: User,
    onItemClick: (User) -> Unit,
    onClick: (User) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(top = 8.dp)
            .height(120.dp)
            .fillMaxWidth(),
        elevation = 4.dp,
        backgroundColor = MaterialTheme.colors.ItemBackgroundColor
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 4.dp)
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Max)
                    .padding(start = 4.dp)
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(user)
                    },
                verticalAlignment = Alignment.CenterVertically
            ) {
                user.avatar?.let {
                    Image(
                        modifier = Modifier
                            .padding(
                                end = 4.dp
                            )
                            .width(100.dp)
                            .clip(shape = androidx.compose.foundation.shape.CircleShape)
                            .aspectRatio(1f),
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

            IconButton(
                onClick = {
                    onClick(user)
                },
                modifier = Modifier
                    .align(
                        Alignment.CenterEnd
                    )
                    .padding(end = 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = if (user.isFavorite) Color.Red else Color.Black
                )
            }
        }
    }

}