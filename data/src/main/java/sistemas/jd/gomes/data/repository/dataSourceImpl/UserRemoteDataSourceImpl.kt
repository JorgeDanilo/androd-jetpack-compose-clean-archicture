package sistemas.jd.gomes.data.repository.dataSourceImpl

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.data.api.UserApi
import sistemas.jd.gomes.data.db.UserDB
import sistemas.jd.gomes.data.paging.UserRemoteMediator
import sistemas.jd.gomes.data.repository.dataSource.UserRemoteDataSource
import sistemas.jd.gomes.domain.model.User

class UserRemoteDataSourceImpl(
    private val userApi: UserApi,
    private val userDB: UserDB
) : UserRemoteDataSource {

    private val userDao = userDB.userDao()

    @OptIn(ExperimentalPagingApi::class)
    override fun getUsers(): Flow<PagingData<User>> {
        val pagingSourceFactory = { userDao.getAllUsers() }
        return Pager(
            config = PagingConfig(pageSize = 6),
            remoteMediator = UserRemoteMediator(
                userApi,
                userDB
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}