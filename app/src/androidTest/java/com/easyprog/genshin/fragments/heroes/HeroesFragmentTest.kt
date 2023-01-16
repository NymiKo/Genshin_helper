package com.easyprog.genshin.fragments.heroes

import com.easyprog.genshin.base.BaseTest
import org.junit.Test

class HeroesFragmentTest : BaseTest() {

    private val heroesFragmentView = HeroesFragmentView()

    @Test
    fun testOpenHeroesFragmentFromMainFragmentOnBottomNavigationView() {
        heroesFragmentView.run {
            heroesItemBottomNavigation.click()
            viewPagerHeroes.check(viewIsDisplayed())
        }
    }

    @Test
    fun testOpenHeroesFragmentFromArtifactsFragmentOnBottomNavigationView() {
        heroesFragmentView.run {
            artifactsItemBottomNavigation.click()
            heroesItemBottomNavigation.click()
            viewPagerHeroes.check(viewIsDisplayed())
        }
    }
}