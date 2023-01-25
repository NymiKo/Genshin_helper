package com.easyprog.genshin.fragments.heroes

import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.domain.StubRepositoryHeroes
import com.easyprog.genshin.model.Heroes
import com.easyprog.genshin.utils.viewModelTestingRules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class HeroesViewModelImplTest {

    @get:Rule
    val viewModelRule = viewModelTestingRules()

    private val repository = StubRepositoryHeroes()

    private lateinit var viewModel: HeroesViewModel

    @Before
    fun initViewModel() {
        viewModel = HeroesViewModelImpl(repository)
    }

    @Test
    fun `get hero`() = runTest {
        val heroesList = listOf(
            HeroesEntity(
                id = 1,
                name = "Итто",
                avatar = 1,
                birthday = "06.02",
                element = "Гео",
                region = "Инадзума",
                talentMaterialId = 0
            )
        )
        repository.setHeroes(heroesList)
        val expectedHeroesList = listOf(
            Heroes(
                id = 1,
                name = "Итто",
                avatar = 1,
                birthday = "06.02",
                element = "Гео",
                region = "Инадзума",
                talentMaterialId = 0
            )
        )

        advanceUntilIdle()
        assertEquals(expectedHeroesList, viewModel.heroesList.value)
    }
}