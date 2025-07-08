package sistemas.jd.gomes.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.domain.model.User

interface UserRepository {
    fun getUsers(): Flow<PagingData<User>>
    fun getUsersFromDB(userId: Int): Flow<User>
    fun getUserByName(name: String): Pager<Int, User>
    fun getFavorites(): Flow<List<User>>
    fun saveFavorite(user: User)
}