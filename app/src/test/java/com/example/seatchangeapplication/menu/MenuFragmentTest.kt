package com.example.seatchangeapplication.menu

import android.widget.Button
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.runner.AndroidJUnit4
import com.example.seatchangeapplication.MainActivity
import com.example.seatchangeapplication.R
import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
//@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MenuFragmentTest {
    @get:Rule
    var taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var subject: MenuFragment
    private lateinit var scenario: FragmentScenario<MenuFragment>

    @Before
    fun setUp() {
        subject = MenuFragment()
    }


    @Test
    fun `ColorConfigButton押下でColorConfigFragment呼び出し`() {
        val activity =
            Robolectric.buildActivity(MainActivity::class.java).create().start().resume().get()
        activity.supportFragmentManager.beginTransaction().add(subject, null).commit()

        subject.view!!.findViewById<Button>(R.id.colorConfigButton).performClick()

        //Shadows.shadowOf(Looper.getMainLooper()).idle()

        val fragment = subject.parentFragmentManager.fragments.last()
        assertThat(fragment, instanceOf(ColorConfigFragment::class.java))

        //TODO:以下のespressoテストではxmlのバインディング式でviewModelの関数を呼ぶボタンの
        // perform(click())が動いてない。
/*        scenario = launchFragmentInContainer<MenuFragment>()

        //↓実行可能
        onView(withId(R.id.hogeButton)).perform(click())

        //可視状態にはなっている模様
        onView(withId(R.id.colorConfigButton)).check(matches(isDisplayed()))
//        onView(withId(R.id.seatChangeButton)).check(matches(isDisplayed()))
//        onView(withId(R.id.projectConfigButton)).check(matches(isDisplayed()))

        //実行不可
        onView(withId(R.id.colorConfigButton)).perform(click())
//        onView(withId(R.id.seatChangeButton)).perform(click())
//        onView(withId(R.id.projectConfigButton)).perform(click())*/
    }
}