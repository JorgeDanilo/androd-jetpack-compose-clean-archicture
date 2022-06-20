package sistemas.jd.gomes.androidcleanarchicturemarvel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sistemas.jd.gomes.data.repository.UserRepositoryImp
import sistemas.jd.gomes.data.repository.dataSource.UserLocalDataSource
import sistemas.jd.gomes.data.repository.dataSource.UserRemoteDataSource
import sistemas.jd.gomes.domain.repository.UserRepository

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideUsersRepository(
        userRemoteDataSource: UserRemoteDataSource,
        userLocalDataSource: UserLocalDataSource
    ) : UserRepository =
        UserRepositoryImp(userRemoteDataSource, userLocalDataSource)
}