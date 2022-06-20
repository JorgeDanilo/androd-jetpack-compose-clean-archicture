package sistemas.jd.gomes.domain.useCase

import sistemas.jd.gomes.domain.repository.UserRepository

class GetUsersUseCase(private val userRepository: UserRepository) {
    operator fun invoke() = userRepository.getUsers()
}