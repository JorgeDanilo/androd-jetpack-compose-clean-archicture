package sistemas.jd.gomes.data.repository.dataSource

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.domain.model.User

interface UserRemoteDataSource {
    fun getUsers(): Flow<PagingData<User>>
}