package com.easyprog.genshin.fragments.artifacts

import com.easyprog.genshin.base.BaseView
import org.junit.Test

class ArtifactsFragmentTest : BaseView() {

    @Test
    fun testOpenArtifactsFragmentFromMainFragmentOnBottomNavigationView() {
        mainFragmentView.artifactsItemBottomNavigation.click()
        artifactsFragmentView.recyclerViewArtifacts.check(viewIsDisplayed())
    }

    @Test
    fun testOpenArtifactsFragmentFromHeroesFragmentOnBottomNavigationView() {
        mainFragmentView.run {
            heroesItemBottomNavigation.click()
            artifactsItemBottomNavigation.click()
        }
        artifactsFragmentView.recyclerViewArtifacts.check(viewIsDisplayed())
    }
}