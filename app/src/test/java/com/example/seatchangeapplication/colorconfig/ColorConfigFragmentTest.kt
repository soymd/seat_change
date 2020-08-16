package com.example.seatchangeapplication.colorconfig

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.runner.AndroidJUnit4
import com.example.seatchangeapplication.R
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.allOf
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
//@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class ColorConfigFragmentTest {
//    @get:Rule
//    var taskExecutorRule = InstantTaskExecutorRule()

    lateinit var subject: ColorConfigFragment
    lateinit var mockViewModel: ColorConfigViewModel
    private lateinit var scenario: FragmentScenario<ColorConfigFragment>

    @Before
    fun setUp() {
        mockViewModel = mockk()
        // subject = ColorConfigFragment(mockViewModel)
    }

    @Ignore
    @Test
    fun foo() {
        // TODO: viewModelのmock方法
        scenario = launchFragmentInContainer<ColorConfigFragment>()
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