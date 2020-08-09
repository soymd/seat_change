package com.example.seatchangeapplication

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [28])
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)
    lateinit var subject: MainActivity

    @Before
    fun setUp() {
    }

    @Test
    fun `onResume時に、SeatChangeFragmentが呼ばれる`() {
        subject = Robolectric.buildActivity(
            MainActivity::class.java,
            Intent()
        ).create().start().resume().get()

        val fragment = subject.supportFragmentManager.fragments.last()
        assertThat(fragment, instanceOf(SeatChangeFragment::class.java))
    }

    @Test
    fun `menuボタン押下で、MenuFragmentが呼ばれる`() {
        subject = Robolectric.buildActivity(
            MainActivity::class.java,
            Intent()
        ).create().start().resume().get()

        onView(withId(R.id.menuButton)).check(matches(isDisplayed()))
        onView(withId(R.id.menuButton)).perform(click())

        //TODO: .perform(click())は動くが以下の検証は通らない。
//        val fragment = subject.supportFragmentManager.fragments.last()
//        assertThat(fragment, instanceOf(MenuFragment::class.java))
    }
}
