package sistemas.jd.gomes.domain.useCase

import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.domain.repository.UserRepository

class GetFavoriteUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke() = userRepository.getFavorites()

    fun saveFavorite(
        user: User,
    ) = userRepository.saveFavorite(user)
}