package sistemas.jd.gomes.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import sistemas.jd.gomes.domain.model.UserResponse

interface UserApi {

    @GET("users")
    suspend fun getUsers(
        @Query("page") page: Int = 1
    ): Response<UserResponse>
}