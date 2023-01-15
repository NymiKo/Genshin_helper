package com.easyprog.genshin.activity

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.easyprog.genshin.R
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testOpenHeroesFragmentFromMainFragmentOnBottomNavigationView() {
        onView(withId(R.id.heroesFragment)).perform(click())
        onView(withId(R.id.view_pager_heroes)).check(matches(isDisplayed()))
    }

    @Test
    fun testOpenArtifactsFragmentOnBottomNavigationView() {
        onView(withId(R.id.artifactsFragment)).perform(click())
        onView(withId(R.id.recycler_view_artifacts_list)).check(matches(isDisplayed()))
    }

    @Test
    fun testOpenHeroesFragmentFromArtifactsFragmentOnBottomNavigationView() {
        onView(withId(R.id.artifactsFragment)).perform(click())
        onView(withId(R.id.heroesFragment)).perform(click())
        onView(withId(R.id.view_pager_heroes)).check(matches(isDisplayed()))
    }

    @Test
    fun testOpenArtifactsFragmentFromHeroesFragmentOnBottomNavigationView() {
        onView(withId(R.id.heroesFragment)).perform(click())
        onView(withId(R.id.artifactsFragment)).perform(click())
        onView(withId(R.id.recycler_view_artifacts_list)).check(matches(isDisplayed()))
    }

    @Test
    fun testOpenMainFragmentFromHeroesFragmentOnBottomNavigationView() {
        onView(withId(R.id.heroesFragment)).perform(click())
        onView(withId(R.id.mainFragment)).perform(click())
        onView(withId(R.id.image_emblem)).check(matches(isDisplayed()))
    }

    @Test
    fun testOpenMainFragmentFromArtifactsFragmentOnBottomNavigationView() {
        onView(withId(R.id.artifactsFragment)).perform(click())
        onView(withId(R.id.mainFragment)).perform(click())
        onView(withId(R.id.image_emblem)).check(matches(isDisplayed()))
    }

    @Test
    fun testOpenGoalsFragment() {
        onView(withId(R.id.button_from_main_to_goals)).perform(click())
        onView(withId(R.id.text_no_goals)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_goals)).check(matches(not(isDisplayed())))
    }

}