package com.easyprog.genshin.base

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.CoreMatchers.not

interface BaseTest {

    fun clickButton(imageRes: Int): ViewInteraction = onView(withId(imageRes)).perform(ViewActions.click())

    fun checkIsDisplayed(res: Int): ViewInteraction = onView(withId(res)).check(matches(isDisplayed()))

    fun checkNotIsDisplayed(res: Int): ViewInteraction = onView(withId(res)).check(matches(not(isDisplayed())))

}