package sistemas.jd.gomes.androidcleanarchicturemarvel.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sistemas.jd.gomes.data.db.UserDB
import sistemas.jd.gomes.data.db.UserDao
import sistemas.jd.gomes.data.db.UserRemoteKeysDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(app: Application): UserDB =
        Room.databaseBuilder(app, UserDB::class.java, "user_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideUserDao(userDB: UserDB) : UserDao = userDB.userDao()

    @Provides
    fun provideUserRemoteKeysDao(userDB: UserDB): UserRemoteKeysDao = userDB.userRemoteKeyDao()
}