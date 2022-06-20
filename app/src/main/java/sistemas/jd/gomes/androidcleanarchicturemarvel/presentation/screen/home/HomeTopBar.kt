package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import sistemas.jd.gomes.androidcleanarchicturemarvel.R
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppContentColor
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppThemColor

@Composable
fun HomeTopBar() {
    val context = LocalContext.current
    TopAppBar(
        backgroundColor = MaterialTheme.colors.AppThemColor,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                color = MaterialTheme.colors.AppContentColor,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.h5
            )
        },
        elevation = 0.dp,
        actions = {
            IconButton(onClick = { showMessage(context = context) }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite Icon",
                    tint = Color.Red
                )
            }
        }
    )
}

private fun showMessage(context: Context) {
    val browserIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://github.com/JorgeDanilo")
    )
    ContextCompat.startActivity(context, browserIntent, null)
}
