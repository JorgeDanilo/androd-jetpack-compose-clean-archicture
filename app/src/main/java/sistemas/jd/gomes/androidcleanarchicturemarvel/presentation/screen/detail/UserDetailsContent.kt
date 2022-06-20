package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import sistemas.jd.gomes.androidcleanarchicturemarvel.ui.theme.AppThemColor
import sistemas.jd.gomes.domain.model.User

@Composable
fun UserDetailsContent(user: User) {
    val scrollState = rememberScrollState()
    Card(
        elevation = 0.dp,
        backgroundColor = MaterialTheme.colors.AppThemColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {

            Image(
                painter = rememberImagePainter(
                    data = user.avatar, builder = {
                        crossfade(true)
                        scale(Scale.FIT)
                    }),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)
            )

            Column(Modifier.padding(8.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                user.firstName?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.h5,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                user.lastName?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                user.email?.let {
                    Text(
                        text = it,
                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }
}