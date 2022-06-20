package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.detail

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import sistemas.jd.gomes.androidcleanarchicturemarvel.R
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppContentColor
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppThemColor

@Composable
fun UserDetailsTopBar(
    navController: NavController
) {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemColor,
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back Icon",
                    tint = MaterialTheme.colors.AppContentColor
                )
            }
        },
        title = {
            Text(
                text = stringResource(R.string.details),
                color = MaterialTheme.colors.AppContentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h6
            )
        },
        elevation = 0.dp
    )
}