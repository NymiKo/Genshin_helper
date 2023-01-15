package com.easyprog.genshin.base

fun navigationMainFragment(func: MainFragmentNavigationRobot.() -> Unit) =
    MainFragmentNavigationRobot().apply { func() }

class MainFragmentNavigationRobot : BaseTest {

    fun clickOnButton(res: Int) = clickButton(res)

    fun checkElementIsDisplayed(res: Int) = checkIsDisplayed(res)

    fun checkElementNotIsDisplayed(res: Int) = checkNotIsDisplayed(res)

}