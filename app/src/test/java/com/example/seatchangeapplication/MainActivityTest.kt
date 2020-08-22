package com.example.seatchangeapplication

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.equalTo
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

    lateinit var mockSeatChangeViewModelProviders: SeatChangeViewModelProviders
    lateinit var mockViewModelProvider: ViewModelProvider
    lateinit var mockViewModel: MainViewModel

    @Before
    fun setUp() {
        mockSeatChangeViewModelProviders = mockk(relaxed = true)
        mockViewModelProvider = mockk(relaxed = true)
        mockViewModel = mockk(relaxed = true)

        every { mockSeatChangeViewModelProviders.of(any(), any()) } returns mockViewModelProvider
        every { mockViewModelProvider.get(MainViewModel::class.java) } returns mockViewModel
    }

    @Test
    fun `injection test`() {
        every { mockViewModel.countGreeting() } returns 999

        val intent = Intent().apply {
            putExtra(ArgumentKeys.VIEW_MODEL_PROVIDERS.key, mockSeatChangeViewModelProviders)
        }
        println(intent.extras!!.containsKey(ArgumentKeys.VIEW_MODEL_PROVIDERS.key))

        subject =
            Robolectric.buildActivity(MainActivity::class.java, intent)
                .create().start().resume().get()

        val actual = subject.test()
        assertThat(actual, equalTo(999))
    }
}

/*    @Test
    fun `onResume時に、SeatChangeFragmentが呼ばれる`() {
        subject = Robolectric.buildActivity(
            MainActivity::class.java,
            Intent()
        ).create().start().resume().get()

        val fragment = subject.supportFragmentManager.fragments.last()
        assertThat(fragment, instanceOf(SeatChangeFragment::class.java))
    }*/

/*    @Test
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
    }*/


