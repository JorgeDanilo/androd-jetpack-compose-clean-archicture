package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

@Composable
fun SearchField(
    searchQuery: String,
    onQueryChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = searchQuery,
        onValueChange = onQueryChanged,
        modifier = modifier
            .clip(MaterialTheme.shapes.small),
        interactionSource = remember {
            MutableInteractionSource()
        },
        placeholder = { Text("Search")},
        leadingIcon = {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon"
            )
        }
    )
}