package sistemas.jd.gomes.data.db

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import sistemas.jd.gomes.domain.model.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addUsers(user: List<User>)

    @Query("UPDATE users SET isFavorite = 1 WHERE id = :userId")
    fun favorite(userId: Int)

    @Query("UPDATE users SET isFavorite = 0 WHERE id = :userId")
    fun unFavorite(userId: Int)

    @Query("SELECT * FROM users WHERE isFavorite = 1")
    fun getAllFavorites(): Flow<List<User>>

    @Query("SELECT EXISTS(SELECT 1 FROM users WHERE id = :userId AND isFavorite = 1)")
    fun isFavorite(userId: Int): Flow<Boolean>

    @Query("SELECT * FROM users")
    fun getAllUsers(): PagingSource<Int, User>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUser(userId: Int): Flow<User>

    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM users WHERE firstName LIKE '%' || :name || '%'")
    fun getUserByName(name: String): PagingSource<Int, User>
}
