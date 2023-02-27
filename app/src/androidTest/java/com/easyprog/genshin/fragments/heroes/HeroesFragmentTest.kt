package com.easyprog.genshin.fragments.heroes

import androidx.test.filters.LargeTest
import com.easyprog.genshin.base.BaseTest
import org.junit.Before
import org.junit.Test

@LargeTest
class HeroesFragmentTest : BaseTest() {

    private val heroesFragmentView = HeroesFragmentView()

    @Before
    fun openHeroesFragment() {
        heroesFragmentView.run {
            heroesItemBottomNavigation.click()
        }
    }

    @Test
    fun testOpenHeroesFragmentFromMainFragmentOnBottomNavigationView() {
        heroesFragmentView.run {
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

    @Test
    fun testOpenHeroProfileFragment() {
        heroesFragmentView.run {
            itemHeroProfile.click()
            imageProfileHeroAvatar.check(viewIsDisplayed())
        }
    }

    @Test
    fun testSwipeViewPagerAndOpenHeroProfileFragment() {
        heroesFragmentView.run {
            viewPagerHeroes.swipeLeft()
            itemHeroProfile.click()
            imageProfileHeroAvatar.check(viewIsDisplayed())
        }
    }
}