package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.favorite

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import sistemas.jd.gomes.androidcleanarchicturemarvel.R
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppContentColor
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppThemColor

@Composable
fun FavoriteTopBar(
    navHostController: NavHostController
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemColor,
        navigationIcon = {
           IconButton({navHostController.popBackStack()}) {
               Icon(
                   imageVector = Icons.Default.ArrowBack,
                   contentDescription = "Back Icon",
                   tint = MaterialTheme.colors.AppContentColor,
               )
           }
        },
        title = {
            Text(
                text = stringResource(R.string.favorite_title),
                color = MaterialTheme.colors.AppContentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        elevation = 0.dp,
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon",
                    tint = Color.Red
                )
            }
        }
    )
}