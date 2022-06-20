package sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import sistemas.jd.gomes.domain.useCase.UserUserCase
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    userUserCase: UserUserCase
) : ViewModel() {

    val getUsers = userUserCase.getUsersUseCase()
}