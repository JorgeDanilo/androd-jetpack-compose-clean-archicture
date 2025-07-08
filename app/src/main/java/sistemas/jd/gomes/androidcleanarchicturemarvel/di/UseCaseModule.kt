package sistemas.jd.gomes.androidcleanarchicturemarvel.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import sistemas.jd.gomes.domain.repository.UserRepository
import sistemas.jd.gomes.domain.useCase.GetFavoriteUseCase
import sistemas.jd.gomes.domain.useCase.GetUsersUseCase
import sistemas.jd.gomes.domain.useCase.GetUsersFromDBUseCase
import sistemas.jd.gomes.domain.useCase.UserUserCase

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideUserUseCase(userRepository: UserRepository) = UserUserCase(
        GetUsersUseCase(userRepository),
        GetUsersFromDBUseCase(userRepository),
    )

    @Provides
    fun provideGetFavoriteUseCase(userRepository: UserRepository) = GetFavoriteUseCase(userRepository)

}