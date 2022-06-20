package sistemas.jd.gomes.domain.useCase

data class UserUserCase(
    val getUsersUseCase: GetUsersUseCase,
    val getUsersFromDBUseCase: GetUsersFromDBUseCase,
)