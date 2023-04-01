package com.easyprog.genshin.fragments.goals

import androidx.test.filters.LargeTest
import com.easyprog.genshin.base.BaseView
import org.junit.Before
import org.junit.Test

@LargeTest
class GoalsFragmentTest : BaseView() {

    @Before
    fun openGoalsFragment() {
        mainFragmentView.buttonOpenGoals.click()
    }

    @Test
    fun testOpenGoalsFragment() {
        goalsFragmentView.recyclerGoals.check(viewIsDisplayed())
    }
}