package sistemas.jd.gomes.androidcleanarchicturemarvel.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.Pager
import androidx.paging.PagingData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceTimeBy
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import sistemas.jd.gomes.androidcleanarchicturemarvel.presentation.screen.home.HomeViewModel
import sistemas.jd.gomes.domain.model.User
import sistemas.jd.gomes.domain.useCase.GetUsersUseCase
import sistemas.jd.gomes.domain.useCase.UserUserCase


class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()
    private val testDispatcher = StandardTestDispatcher()

    @Mock
    private lateinit var getUsersUseCase: GetUsersUseCase

    @Mock
    private lateinit var userUserCase: UserUserCase


    private lateinit var viewModel: HomeViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        val fakeUser = User(1, 12, "First", "Last", "email@test.com", "")
        val pagingData = PagingData.from(listOf(fakeUser))
        val fakeFlow = flowOf(pagingData)

        val mockPager = mock(Pager::class.java) as Pager<Int, User>
        `when`(mockPager.flow).thenReturn(fakeFlow)
        `when`(getUsersUseCase.getUserByName(anyString())).thenReturn(mockPager)
        `when`(userUserCase.getUsersUseCase).thenReturn(getUsersUseCase)


        viewModel = HomeViewModel(userUserCase)
    }

    @Test
    fun `test onQueryChanged updates query and emits users` () = runTest {
        val expectedQuery = "Jorge"
        viewModel.onQueryChanged(expectedQuery)
        advanceTimeBy(350)

        val result = mutableListOf<PagingData<User>>()
        val job = launch {
            viewModel.users.collect {
                result.add(it)
            }
        }
        advanceUntilIdle()
        assert(result.isNotEmpty())
        job.cancel()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}