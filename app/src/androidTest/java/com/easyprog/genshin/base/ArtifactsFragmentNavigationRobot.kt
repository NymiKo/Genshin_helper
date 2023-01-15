package com.easyprog.genshin.base

import com.easyprog.genshin.R

fun navigationArtifactsFragment(func: ArtifactsFragmentNavigationRobot.() -> Unit) =
    ArtifactsFragmentNavigationRobot().apply { func() }

class ArtifactsFragmentNavigationRobot : BaseTest {

    fun clickArtifactsButton() = clickButton(R.id.artifactsFragment)

    fun clickHeroesButton() = clickButton(R.id.heroesFragment)

    fun checkArtifactsRecyclerViewIsDisplayed() =
        checkIsDisplayed(R.id.recycler_view_artifacts_list)

}