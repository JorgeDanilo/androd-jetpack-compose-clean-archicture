package sistemas.jd.gomes.data.repository.dataSource

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.domain.model.User

interface UserLocalDataSource {
    fun getUsersFromDB(userId : Int): Flow<User>
    fun getUserByName(name: String): PagingSource<Int, User>
    fun getFavorites(): Flow<List<User>>
    fun saveFavorite(user: User)
}