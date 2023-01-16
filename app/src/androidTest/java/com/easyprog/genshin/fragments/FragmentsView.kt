package com.easyprog.genshin.fragments

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewInteraction
import androidx.test.espresso.matcher.ViewMatchers.withId

abstract class FragmentsView {

    protected fun Int.view(): ViewInteraction = onView(withId(this))

}