package sistemas.jd.gomes.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.domain.model.UserRemoteKeys

@Database(
    entities = [User::class, UserRemoteKeys::class],
    version = 2, // de 1 para 2
    exportSchema = false
)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun userRemoteKeyDao(): UserRemoteKeysDao
}