package sistemas.jd.gomes.androidcleanarchicturemarvel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sistemas.jd.gomes.data.db.UserDao
import sistemas.jd.gomes.data.repository.dataSource.UserLocalDataSource
import sistemas.jd.gomes.data.repository.dataSourceImpl.UserLocalDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object LocalDataModule {

    @Provides
    fun provideLocalDataSource(userDao: UserDao) : UserLocalDataSource =
        UserLocalDataSourceImpl(userDao)
}