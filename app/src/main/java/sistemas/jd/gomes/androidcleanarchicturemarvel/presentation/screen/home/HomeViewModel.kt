package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.domain.useCase.UserUserCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    userUserCase: UserUserCase
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query

    fun onQueryChanged(query: String) {
        _query.value = query
    }

    @OptIn(FlowPreview::class, ExperimentalCoroutinesApi::class)
    val users :StateFlow<PagingData<User>> = _query
        .debounce(300)
        .distinctUntilChanged()
        .flatMapLatest { query ->
            userUserCase.getUsersUseCase.getUserByName(query).flow
        }
        .cachedIn(viewModelScope)
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            PagingData.empty()
        )
}