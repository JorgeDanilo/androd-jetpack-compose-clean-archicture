package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.domain.useCase.UserUserCase
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(
    private val userUserCase: UserUserCase
) : ViewModel() {

    private val _selectedUser: MutableStateFlow<User?> = MutableStateFlow(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    fun getUserDetails(userId: Int) = viewModelScope.launch {
        userUserCase.getUsersFromDBUseCase.invoke(userId).collect {
            _selectedUser.value = it
        }
    }
}