package sistemas.jd.gomes.androidcleanarchicturemarvel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sistemas.jd.gomes.data.api.UserApi
import sistemas.jd.gomes.data.db.UserDB
import sistemas.jd.gomes.data.repository.dataSource.UserRemoteDataSource
import sistemas.jd.gomes.data.repository.dataSourceImpl.UserRemoteDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {

    @Provides
    fun provideUsersRemoteDataSource(userApi: UserApi, userDB: UserDB): UserRemoteDataSource =
        UserRemoteDataSourceImpl(userApi, userDB)
}