package com.easyprog.genshin.base

import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.easyprog.genshin.activity.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
abstract class BaseTest {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    protected fun ViewInteraction.click(): ViewInteraction = perform(ViewActions.click())

    protected fun viewIsDisplayed(): ViewAssertion =
        matches(ViewMatchers.isDisplayed())

    protected fun viewIsChecked(): ViewAssertion =
        matches(ViewMatchers.isChecked())

    protected fun ViewInteraction.swipeLeft(): ViewInteraction = perform(ViewActions.swipeLeft())

    protected fun viewNotIsDisplayed(): ViewAssertion =
        matches(not(ViewMatchers.isDisplayed()))

}