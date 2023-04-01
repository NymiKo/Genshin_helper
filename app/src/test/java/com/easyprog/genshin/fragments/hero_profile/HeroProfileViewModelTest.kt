package com.easyprog.genshin.fragments.hero_profile

import com.easyprog.domain.FakeHeroProfileRepository
import com.easyprog.genshin.model.Hero
import com.easyprog.genshin.utils.TestDispatchersList
import com.easyprog.genshin.utils.viewModelTestingRules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class HeroProfileViewModelTest {

    @get:Rule
    val viewModelRule = viewModelTestingRules()
    private val repository = FakeHeroProfileRepository()
    private lateinit var viewModel: HeroProfileViewModel

    @Before
    fun initViewModel() {
        viewModel = HeroProfileViewModelImpl(repository, TestDispatchersList())
    }

    @Test
    fun `get hero`() = runTest {
        val expectedHero = Hero(
            id = 1,
            name = "Итто",
            avatar = 1,
            birthday = "02.03.1999",
            element = "Гео",
            region = "Инадзума",
            talentMaterialId = 1
        )
        repository.setHero(expectedHero)
        viewModel.getHero(1)
        val actualHero = viewModel.hero.value
        assertEquals(expectedHero, actualHero)
    }
}