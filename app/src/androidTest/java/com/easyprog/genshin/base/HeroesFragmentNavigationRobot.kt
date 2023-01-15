package com.easyprog.genshin.base

import com.easyprog.genshin.R

fun navigationHeroesFragment(func: HeroesFragmentNavigationRobot.() -> Unit) =
    HeroesFragmentNavigationRobot().apply { func() }

class HeroesFragmentNavigationRobot : BaseTest {

    fun clickHeroesButton() = clickButton(R.id.heroesFragment)

    fun clickArtifactsButton() = clickButton(R.id.artifactsFragment)

    fun checkHeroesViewPagerIsDisplayed() = checkIsDisplayed(R.id.view_pager_heroes)

}