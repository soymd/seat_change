package com.example.seatchangeapplication.colorconfig

import android.os.Bundle
import androidx.fragment.app.FragmentManager
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
    lateinit var bundle: Bundle

    lateinit var fragmentManager: FragmentManager

    private lateinit var scenario: FragmentScenario<ColorConfigFragment>


    @Before
    fun setUp() {
        mockViewModel = mockk(relaxed = true)

        mockSeatChangeViewModelProviders = mockk(relaxed = true)
        mockViewModelProvider = mockk(relaxed = true)

        every { mockSeatChangeViewModelProviders.of(any(), any()) } returns mockViewModelProvider
        every { mockViewModelProvider.get(ColorConfigViewModel::class.java) } returns mockViewModel
        subject = ColorConfigFragment()

        bundle = Bundle().apply {
            putSerializable(ArgumentKeys.VIEW_MODEL_PROVIDERS.key, mockSeatChangeViewModelProviders)
        }
        subject.arguments = bundle
        fragmentManager =
            Robolectric.buildActivity(MainActivity::class.java).create().start().resume()
                .get().supportFragmentManager
    }

    @Test
    fun `injection test`() {
        every { mockViewModel.greeting() } returns "hello"

        fragmentManager.beginTransaction().add(subject, null).commit()

        val actual = subject.getGreeting()

        assertThat(actual, equalTo("hello"))
    }

    @Test
    fun `onCreateView recyclerViewの一覧にプロジェクト名が表示される`() {
        val model = ColorConfigModel.from()
        model.projectName = "fake-project"
        every { mockViewModel.getColorList() } returns listOf(model)

        scenario = launchFragmentInContainer<ColorConfigFragment>(
            bundle,
            R.style.AppTheme,
            null
        )

        onView(
            allOf(
                withId(R.id.colorListView),
                hasDescendant(withText("fake-project"))
            )
        ).check(matches(isDisplayed()))
    }
}