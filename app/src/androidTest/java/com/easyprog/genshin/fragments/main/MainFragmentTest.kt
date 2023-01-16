package com.easyprog.genshin.fragments.main

import com.easyprog.genshin.base.BaseTest
import org.junit.Test

class MainFragmentTest : BaseTest() {

    private val maimFragmentView = MainFragmentView()

    @Test
    fun testOpenMainFragmentFromHeroesFragmentOnBottomNavigationView() {
        maimFragmentView.run {
            heroesItemBottomNavigation.click()
            mainItemBottomNavigation.click()
            imageViewEmblem.check(viewIsDisplayed())
        }
    }

    @Test
    fun testOpenMainFragmentFromArtifactsFragmentOnBottomNavigationView() {
        maimFragmentView.run {
            artifactsItemBottomNavigation.click()
            mainItemBottomNavigation.click()
            imageViewEmblem.check(viewIsDisplayed())
        }
    }
}