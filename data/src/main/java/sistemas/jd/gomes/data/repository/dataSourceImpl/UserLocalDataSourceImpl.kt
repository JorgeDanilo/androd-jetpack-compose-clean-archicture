package sistemas.jd.gomes.data.repository.dataSourceImpl

import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.data.db.UserDao
import sistemas.jd.gomes.data.repository.dataSource.UserLocalDataSource
import sistemas.jd.gomes.domain.model.User

class UserLocalDataSourceImpl(
    private val userDao: UserDao
) : UserLocalDataSource {

    override fun getUsersFromDB(userId: Int): Flow<User> = userDao.getUser(userId)
    override fun getUserByName(name: String): PagingSource<Int, User> = userDao.getUserByName(name)
}