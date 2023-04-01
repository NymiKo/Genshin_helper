package com.easyprog.genshin.fragments.goals

import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.data.storage.additional_models.hero.HeroAvatar
import com.easyprog.data.storage.entities.PriorityHeroesEntity
import com.easyprog.domain.FakeGoalsRepository
import com.easyprog.genshin.DispatchersList
import com.easyprog.genshin.utils.MainCoroutineDispatcherRule
import com.easyprog.genshin.utils.TestDispatchersList
import com.easyprog.genshin.utils.viewModelTestingRules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class GoalsViewModelTest {

    @get:Rule
    val viewModelRule = viewModelTestingRules()

    private val repository = FakeGoalsRepository()

    private lateinit var viewModel: GoalsViewModel

    @Before
    fun initViewModel() {
        viewModel = GoalsViewModelImpl(repository, TestDispatchersList())
    }

    @Test
    fun `get goals heroes`() = runTest {
        val priorityHeroesList = listOf(
            PriorityHeroesEntity(
                heroId = 1,
                elevationPriority = true,
                talentPriority = false,
                artifactPriority = true
            ),
            PriorityHeroesEntity(
                heroId = 2,
                elevationPriority = false,
                talentPriority = true,
                artifactPriority = false
            )
        )

        val heroesAvatarsList = listOf(
            HeroAvatar(avatar = 1),
            HeroAvatar(avatar = 2)
        )

        val priorityWithHero = mutableListOf<PriorityWithHero>()
        for (i in priorityHeroesList.indices) {
            priorityWithHero.add(PriorityWithHero(priority = priorityHeroesList[i], heroAvatar = heroesAvatarsList[i]))
        }
        repository.setPriorityWithHeroesList(priorityWithHero)
        viewModel.getGoalsHeroes()
        assertEquals(priorityWithHero, viewModel.goalsHeroesList.value)
    }

}