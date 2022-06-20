package sistemas.jd.gomes.data.repository.dataSource

import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.domain.model.User

interface UserLocalDataSource {
    fun getUsersFromDB(userId : Int): Flow<User>
}