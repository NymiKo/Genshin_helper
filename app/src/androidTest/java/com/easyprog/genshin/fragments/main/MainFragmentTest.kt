package com.easyprog.genshin.fragments.main

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.easyprog.genshin.R
import com.easyprog.genshin.activity.MainActivity
import com.easyprog.genshin.base.navigationMainFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testOpenMainFragmentFromHeroesFragmentOnBottomNavigationView() {
        navigationMainFragment {
            clickOnButton(R.id.heroesFragment)
            clickOnButton(R.id.mainFragment)
            checkElementIsDisplayed(R.id.image_emblem)
        }
    }

    @Test
    fun testOpenMainFragmentFromArtifactsFragmentOnBottomNavigationView() {
        navigationMainFragment {
            clickOnButton(R.id.artifactsFragment)
            clickOnButton(R.id.mainFragment)
            checkElementIsDisplayed(R.id.image_emblem)
        }
    }

    @Test
    fun testOpenGoalsFragment() {
        navigationMainFragment {
            clickOnButton(R.id.button_from_main_to_goals)
            checkElementIsDisplayed(R.id.text_no_goals)
            checkElementNotIsDisplayed(R.id.recycler_goals)
        }
    }

}