package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.size.Scale
import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.androidcleanarchicturemarvel.R

@Composable
fun UserDetailsContent(user: User) {

    val scrollState = rememberScrollState()

    Column(modifier = Modifier.fillMaxSize()) {

        BoxWithConstraints {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                ) {
                    UserHeader(user, this@BoxWithConstraints.maxHeight)
                    UserContent(user, this@BoxWithConstraints.maxHeight)
                }
            }
        }

    }
}

@Composable
fun UserContent(user: User, containerHeight: Dp) {
    Column {
        Spacer(modifier = Modifier.heightIn(8.dp))
        Name(user)
        user.lastName?.let { UserProperty(stringResource(R.string.lastName), it) }
        user.email?.let { UserProperty(label = stringResource(R.string.email), value = it) }

        Spacer(modifier = Modifier.height((containerHeight - 320.dp).coerceAtLeast(0.dp)))
    }
}

@Composable
fun UserProperty(label: String, value: String, isLink: Boolean = false) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Divider()
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Text(
                text = label,
                modifier = Modifier.paddingFromBaseline(24.dp),
                style = MaterialTheme.typography.caption
            )
        }
        val style = if (isLink) {
            MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.primary)
        } else {
            MaterialTheme.typography.body1
        }

        Text(
            text = value,
            modifier = Modifier.paddingFromBaseline(24.dp),
            style = style
        )

    }
}

@Composable
private fun Name(user: User) {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)) {
        Name(
            user = user,
            modifier = Modifier.paddingFromBaseline(32.dp)
        )
    }
}

@Composable
private fun Name(user: User, modifier: Modifier = Modifier) {
    user.firstName?.let {
        Text(
            text = it,
            modifier = modifier,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun UserHeader(user: User, containerHeight: Dp) {
    Image(
        modifier = Modifier
            .heightIn(max = containerHeight / 2)
            .fillMaxWidth(),
        painter = rememberImagePainter(
            data = user.avatar, builder = {
                crossfade(true)
                scale(Scale.FIT)
            }),
        contentScale = ContentScale.Crop,
        contentDescription = null
    )
}
