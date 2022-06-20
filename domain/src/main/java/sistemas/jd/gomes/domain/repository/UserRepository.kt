package sistemas.jd.gomes.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.domain.model.User

interface UserRepository {
    fun getUsers(): Flow<PagingData<User>>
    fun getUsersFromDB(userId: Int): Flow<User>
}