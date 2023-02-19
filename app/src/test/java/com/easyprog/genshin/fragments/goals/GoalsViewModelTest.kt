package com.easyprog.genshin.fragments.goals

import com.easyprog.data.storage.additional_models.PriorityWithHero
import com.easyprog.data.storage.additional_models.hero.HeroAvatar
import com.easyprog.data.storage.model.HeroesEntity
import com.easyprog.data.storage.model.PriorityHeroesEntity
import com.easyprog.domain.FakeRepositoryGoals
import com.easyprog.genshin.model.PriorityHeroes
import com.easyprog.genshin.utils.viewModelTestingRules
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class GoalsViewModelTest {

    @get:Rule
    val viewModelRule = viewModelTestingRules()

    private val repository = FakeRepositoryGoals()

    private lateinit var viewModel: GoalsViewModel

    @Before
    fun initViewModel() {
        viewModel = GoalsViewModelImpl(repository)
    }

    @Test
    fun `get goals heroes`() = runTest {
        val priorityHeroesList = listOf(
            PriorityHeroesEntity(
                id = 1,
                elevationPriority = true,
                talentPriority = false,
                artifactPriority = true,
                heroId = 1
            ),
            PriorityHeroesEntity(
                id = 2,
                elevationPriority = false,
                talentPriority = true,
                artifactPriority = false,
                heroId = 2
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

        advanceUntilIdle()
        assertEquals(priorityWithHero, viewModel.goalsHeroesList.value)
    }

}