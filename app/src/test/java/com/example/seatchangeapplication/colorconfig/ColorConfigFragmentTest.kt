package com.example.seatchangeapplication.colorconfig

import android.os.Bundle
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.seatchangeapplication.MainActivity
import com.example.seatchangeapplication.R
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

//@RunWith(AndroidJUnit4::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class ColorConfigFragmentTest {
    lateinit var subject: ColorConfigFragment
    lateinit var mockViewModel: ColorConfigViewModel
    lateinit var mockSeatChangeViewModelProviders: SeatChangeViewModelProviders
    lateinit var mockViewModelProvider: ViewModelProvider

    private lateinit var scenario: FragmentScenario<ColorConfigFragment>

    @Before
    fun setUp() {
        mockViewModel = mockk(relaxed = true)

        mockSeatChangeViewModelProviders = mockk(relaxed = true)
        mockViewModelProvider = mockk(relaxed = true)

        every { mockSeatChangeViewModelProviders.of(any(), any()) } returns mockViewModelProvider
        every { mockViewModelProvider.get(ColorConfigViewModel::class.java) } returns mockViewModel
        subject = ColorConfigFragment()
    }

    @Test
    fun viewModelFactoryTest() {
        every { mockViewModel.greeting() } returns "hello"

        subject.arguments = Bundle().apply {
            putSerializable(ArgumentKeys.VIEW_MODEL_PROVIDERS.key, mockSeatChangeViewModelProviders)
        }
        val fragmentManager = Robolectric.buildActivity(MainActivity::class.java)
            .create().start().resume().get().supportFragmentManager
        fragmentManager.beginTransaction().add(subject, null).commit()

        val actual = subject.getGreeting()

        assertThat(actual, equalTo("hello"))
    }


    @Ignore
    @Test
    fun espresso() {
        // TODO: viewModelのmock方法
        scenario = launchFragmentInContainer<ColorConfigFragment>(
            null,
            R.style.AppTheme,
            null
        )
        val model = ColorConfigModel.from()
        model.projectName = "fake-project"
        every { mockViewModel.getColorList() } returns listOf(model)

        onView(
            allOf(
                withId(R.id.colorListView),
                withText("fake-project")
            )
        ).check(matches(isDisplayed()))
    }
}