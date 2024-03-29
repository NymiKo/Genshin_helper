package com.easyprog.genshin.fragments.heroes

import com.easyprog.data.storage.entities.HeroesEntity
import com.easyprog.domain.FakeHeroesRepository
import com.easyprog.genshin.utils.TestDispatchersList
import com.easyprog.genshin.utils.viewModelTestingRules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class HeroesViewModelImplTest {

    @get:Rule
    val viewModelRule = viewModelTestingRules()

    private val repository = FakeHeroesRepository()

    private lateinit var viewModel: HeroesViewModel

    @Before
    fun initViewModel() {
        viewModel = HeroesViewModelImpl(repository, TestDispatchersList())
    }

    @Test
    fun `get hero list`() = runTest {
        val heroesList = listOf(
            HeroesEntity(
                id = 1,
                name = "Итто",
                avatar = 1,
                birthday = "06.02",
                element = "Гео",
                region = "Инадзума",
                talentMaterialId = 0
            ),
            HeroesEntity(
                id = 2,
                name = "Чжун Ли",
                avatar = 2,
                birthday = "07.02",
                element = "Гео",
                region = "Ли Юэ",
                talentMaterialId = 1
            )
        )
        repository.setHeroes(heroesList)
        viewModel.getHeroes()
        val expectedHeroesList = heroesList.map { it.toHeroes() }
        assertEquals(expectedHeroesList, viewModel.heroesList.value)
    }
}