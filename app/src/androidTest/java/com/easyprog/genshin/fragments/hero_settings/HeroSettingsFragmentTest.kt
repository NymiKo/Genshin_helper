package com.easyprog.genshin.fragments.hero_settings

import androidx.test.filters.LargeTest
import com.easyprog.genshin.base.BaseView
import org.junit.Before
import org.junit.Test

@LargeTest
class HeroSettingsFragmentTest: BaseView() {

    @Before
    fun openHeroSettingsFragment() {
        mainFragmentView.heroesItemBottomNavigation.click()
        heroesFragmentView.itemHeroProfile.click()
        heroProfileFragmentView.buttonSettingsHero.click()
    }

    @Test
    fun testOpenHeroSettingsFragment() {
        heroSettingsFragmentView.switchElevationPriority.check(viewIsDisplayed())
    }

    @Test
    fun testChangeSwitchElevationPriorityState() {
        heroSettingsFragmentView.switchElevationPriority.click()
        heroSettingsFragmentView.switchElevationPriority.check(viewIsChecked())
    }

    @Test
    fun testChangeSwitchArtifactPriorityState() {
        heroSettingsFragmentView.switchArtifactPriority.click()
        heroSettingsFragmentView.switchArtifactPriority.check(viewIsChecked())
    }

    @Test
    fun testChangeSwitchTalentPriorityState() {
        heroSettingsFragmentView.switchTalentPriority.click()
        heroSettingsFragmentView.switchTalentPriority.check(viewIsChecked())
    }
}