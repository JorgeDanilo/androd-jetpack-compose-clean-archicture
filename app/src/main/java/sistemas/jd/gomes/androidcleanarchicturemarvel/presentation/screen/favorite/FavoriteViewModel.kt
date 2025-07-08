package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.withContext
import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.domain.useCase.GetFavoriteUseCase
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private var favoriteUseCase: GetFavoriteUseCase
) : ViewModel() {

    val favoritesUsers: StateFlow<List<User>> = favoriteUseCase.invoke()
        .stateIn(viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    suspend fun saveFavorite(user: User) = withContext(Dispatchers.IO) {
        favoriteUseCase.saveFavorite(user)
    }
}