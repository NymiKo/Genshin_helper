package com.easyprog.genshin.fragments.hero_profile

import androidx.test.filters.LargeTest
import com.easyprog.genshin.base.BaseView
import org.junit.Before
import org.junit.Test

@LargeTest
class HeroProfileFragmentTest : BaseView() {

    @Before
    fun openHeroProfileFragment() {
        mainFragmentView.heroesItemBottomNavigation.click()
        heroesFragmentView.itemHeroProfile.click()
    }

    @Test
    fun testOpenHeroProfileFragment() {
        heroProfileFragmentView.buttonSettingsHero.check(viewIsDisplayed())
    }
}