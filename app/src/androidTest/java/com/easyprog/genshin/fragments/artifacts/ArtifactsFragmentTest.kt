package com.easyprog.genshin.fragments.artifacts

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.easyprog.genshin.activity.MainActivity
import com.easyprog.genshin.base.navigationArtifactsFragment
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ArtifactsFragmentTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testOpenArtifactsFragmentOnBottomNavigationView() {
        navigationArtifactsFragment {
            clickArtifactsButton()
            checkArtifactsRecyclerViewIsDisplayed()
        }
    }

    @Test
    fun testOpenArtifactsFragmentFromHeroesFragmentOnBottomNavigationView() {
        navigationArtifactsFragment {
            clickHeroesButton()
            clickArtifactsButton()
            checkArtifactsRecyclerViewIsDisplayed()
        }
    }
}