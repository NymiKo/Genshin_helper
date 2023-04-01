package com.easyprog.genshin.fragments.heroes

import androidx.test.filters.LargeTest
import com.easyprog.genshin.base.BaseView
import org.junit.Before
import org.junit.Test

@LargeTest
class HeroesFragmentTest : BaseView() {

    @Before
    fun openHeroesFragment() {
        mainFragmentView.heroesItemBottomNavigation.click()
    }

    @Test
    fun testOpenHeroesFragmentFromMainFragmentOnBottomNavigationView() {
        heroesFragmentView.viewPagerHeroes.check(viewIsDisplayed())
    }

    @Test
    fun testOpenHeroesFragmentFromArtifactsFragmentOnBottomNavigationView() {
        mainFragmentView.artifactsItemBottomNavigation.click()
        mainFragmentView.heroesItemBottomNavigation.click()
        heroesFragmentView.viewPagerHeroes.check(viewIsDisplayed())
    }

    @Test
    fun testSwipeViewPagerAndOpenHeroProfileFragment() {
        heroesFragmentView.run {
            viewPagerHeroes.swipeLeft()
            Thread.sleep(1000)
            itemHeroProfile.click()
        }
        heroProfileFragmentView.buttonSettingsHero.check(viewIsDisplayed())
    }
}