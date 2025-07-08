package sistemas.jd.gomes.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.data.repository.dataSource.UserLocalDataSource
import sistemas.jd.gomes.data.repository.dataSource.UserRemoteDataSource
import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.domain.repository.UserRepository

class UserRepositoryImp(
    private val userRemoteDataSourceImpl: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource
) : UserRepository {

    override fun getUsers(): Flow<PagingData<User>> =
        userRemoteDataSourceImpl.getUsers()

    override fun getUsersFromDB(userId: Int): Flow<User> =
        userLocalDataSource.getUsersFromDB(userId)

    override fun getUserByName(name: String): Pager<Int, User> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            pagingSourceFactory = { userLocalDataSource.getUserByName(name) }
        )
    }

    override fun getFavorites(): Flow<List<User>> {
        return userLocalDataSource.getFavorites()
    }

    override fun saveFavorite(user: User) {
        return userLocalDataSource.saveFavorite(user)
    }
}