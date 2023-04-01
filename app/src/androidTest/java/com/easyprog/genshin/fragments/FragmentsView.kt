package com.easyprog.genshin.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.*
import org.hamcrest.Matchers.allOf

abstract class FragmentsView {

    protected fun Int.view(): ViewInteraction = onView(withId(this))
    protected fun Int.allViewIsDisplayed(): ViewInteraction =
        onView(allOf(withId(this), isCompletelyDisplayed()))

}