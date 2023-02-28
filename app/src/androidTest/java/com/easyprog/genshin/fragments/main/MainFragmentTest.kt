package com.easyprog.genshin.fragments.main

import com.easyprog.genshin.base.BaseView
import org.junit.Test

class MainFragmentTest : BaseView() {

    @Test
    fun testOpenMainFragmentFromHeroesFragmentOnBottomNavigationView() {
        mainFragmentView.run {
            heroesItemBottomNavigation.click()
            mainItemBottomNavigation.click()
            imageViewEmblem.check(viewIsDisplayed())
        }
    }

    @Test
    fun testOpenMainFragmentFromArtifactsFragmentOnBottomNavigationView() {
        mainFragmentView.run {
            artifactsItemBottomNavigation.click()
            mainItemBottomNavigation.click()
            imageViewEmblem.check(viewIsDisplayed())
        }
    }
}