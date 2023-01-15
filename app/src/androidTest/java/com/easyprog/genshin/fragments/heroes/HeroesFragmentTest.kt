package com.easyprog.genshin.fragments.heroes

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.easyprog.genshin.activity.MainActivity
import com.easyprog.genshin.base.navigationHeroesFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HeroesFragmentTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testOpenHeroesFragmentFromMainFragmentOnBottomNavigationView() {
        navigationHeroesFragment {
            clickHeroesButton()
            checkHeroesViewPagerIsDisplayed()
        }
    }

    @Test
    fun testOpenHeroesFragmentFromArtifactsFragmentOnBottomNavigationView() {
        navigationHeroesFragment {
            clickArtifactsButton()
            clickHeroesButton()
            checkHeroesViewPagerIsDisplayed()
        }
    }

}