package com.easyprog.genshin.fragments.hero_settings

import com.easyprog.domain.FakeHeroSettingsRepository
import com.easyprog.genshin.model.PriorityHeroes
import com.easyprog.genshin.utils.TestDispatchersList
import com.easyprog.genshin.utils.viewModelTestingRules
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class HeroSettingsViewModelImplTest {

    @get:Rule
    val viewModelRule = viewModelTestingRules()

    private val repository = FakeHeroSettingsRepository()
    private lateinit var viewModel: HeroSettingsViewModel

    @Before
    fun initViewModel() {
        viewModel = HeroSettingsViewModelImpl(repository, TestDispatchersList())
    }

    @Test
    fun `get hero settings`() = runTest {
        val fakeIdHero = 1
        val expectedHeroSettings = listOf(
            PriorityHeroes(
                0,
                elevationPriority = true,
                talentPriority = false,
                artifactPriority = true
            ),
            PriorityHeroes(
                1,
                elevationPriority = true,
                talentPriority = true,
                artifactPriority = false
            )
        )
        repository.setHeroSettings(expectedHeroSettings)
        viewModel.getHeroSettings(fakeIdHero)
        val actualHeroSettings = viewModel.heroSettings.value
        assertEquals(expectedHeroSettings[fakeIdHero], actualHeroSettings)
    }
}