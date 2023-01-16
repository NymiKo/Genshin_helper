package com.easyprog.genshin.fragments.artifacts

import com.easyprog.genshin.base.BaseTest
import org.junit.Test

class ArtifactsFragmentTest : BaseTest() {

    private val artifactsFragmentView = ArtifactsFragmentView()

    @Test
    fun testOpenArtifactsFragmentFromMainFragmentOnBottomNavigationView() {
        artifactsFragmentView.run {
            artifactsItemBottomNavigation.click()
            recyclerViewArtifacts.check(viewIsDisplayed())
        }
    }

    @Test
    fun testOpenArtifactsFragmentFromHeroesFragmentOnBottomNavigationView() {
        artifactsFragmentView.run {
            heroesItemBottomNavigation.click()
            artifactsItemBottomNavigation.click()
            recyclerViewArtifacts.check(viewIsDisplayed())
        }
    }
}