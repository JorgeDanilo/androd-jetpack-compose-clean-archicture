package sistemas.jd.gomes.domain.useCase

import sistemas.jd.gomes.domain.repository.UserRepository

class GetUsersFromDBUseCase(
    private val userRepository: UserRepository
) {
    operator fun invoke(userId: Int) = userRepository.getUsersFromDB(userId)
}
